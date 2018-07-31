package com.joaohenrique.HelpDesk.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaohenrique.HelpDesk.api.Service.UserService;
import com.joaohenrique.HelpDesk.api.entity.User;
import com.joaohenrique.HelpDesk.api.response.Response;

@RestController // para termos uma classe restful
@RequestMapping("/api/user") // nosso endpoint
@CrossOrigin(origins = "*") // permitir qualquer acesso. Poderia colocar apenas meu IP, ou afns
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired // para encriptar a senha do usuário
	private PasswordEncoder passwordEncoder;

	// todos os métodos vão retornar um objeto do tipo Response

	@PostMapping // Quando chamar o método via post, vai cair neste método
	@PreAuthorize("hasAnyRole('ADMIN')") // Autorização de acordo com o perfil,somente administrador pode criar usuário
	//parâmetro request pega a requisição
	//parâmetro user pega o usuário a ser criado
	//parâmetro result para colocar o erro nas validações, caso exista
	public ResponseEntity<Response<User>> create(HttpServletRequest request, @RequestBody User user, BindingResult result) {		
		Response<User> response = new Response<User>();
		
		try {
			validateCreateUser(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));//pega os erros que vem no result e 
																											//coloca no response
				return ResponseEntity.badRequest().body(response);
			}
			
			user.setPassword(passwordEncoder.encode(user.getPassword())); //criptografa a senha antes de mandar para o banco
			User userPersisted = (User) userService.creatOrUpdate(user); // userPersisted é nosso novo usuário criado no banco
			response.setData(userPersisted);// retorna o usuário que acabou de ser criado, mostrando suas informações persistidas para quem fez a requisição
		} catch (DuplicateKeyException dE) {
			response.getErrors().add("Email already registered!");
			return ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response); // caso dê tudo certo
	}
	
	//método para válidar a criação de um usuário
	private void validateCreateUser(User user, BindingResult result) {
		if(user.getEmail() == null) {
			result.addError(new ObjectError("User", "Email no information!"));
		}
	}
	
	@PutMapping //put para alteração
	@PreAuthorize("hasAnyRole('ADMIN')") // Autorização de acordo com o perfil,somente administrador pode alterar usuário
	public ResponseEntity<Response<User>> update(HttpServletRequest request, @RequestBody User user, BindingResult result){
		Response<User> response = new Response<User>();
		
		try {
			validateUpdateUser(user, result);
			if(result.hasErrors()) {
				result.getAllErrors().forEach(erros -> response.getErrors().add(erros.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User userPersisted = (User) userService.creatOrUpdate(user);
			response.setData(userPersisted);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
		 
		return ResponseEntity.ok(response);
	}
	
	private void validateUpdateUser(User user, BindingResult result) {
		if(user.getId() == null) {
			result.addError(new ObjectError("User", "Id no information!"));
		}
		
		if(user.getEmail() == null) {
			result.addError(new ObjectError("User", "Email no information!"));
		}
	}
	
	//VER SE ISSO VAI DAR CERTO HEHE
	@GetMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Optional<User>>> findById(@PathVariable("id") String id){
		Response<Optional<User>> response = new Response<Optional<User>>();
		Optional<User> user = userService.findById(id);
		if(user == null) {
			response.getErrors().add("Resgister not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}
	
	
	@DeleteMapping(value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id){
		Response<String> response = new Response<String>();
		Optional<User> user = userService.findById(id);
		if(user == null) {
			response.getErrors().add("Resgister not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		userService.delete(id);
		return ResponseEntity.ok(new Response<String>());
	}
	
	
	@GetMapping(value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Page<User>>> findAll(@PathVariable int page, @PathVariable int count){
		Response<Page<User>> response = new Response<Page<User>>();
		Page<User> users = userService.findAll(page, count);
		response.setData(users);
		return ResponseEntity.ok(response);
	}
	
}
