package com.joaohenrique.HelpDesk.api.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joaohenrique.HelpDesk.api.enums.ProfileEnum;

@Document //Anotação para trabalhar com o mongodb
public class User {
	
	@Id //define id para a "tabela/documento"
	private String id;
	
	@Indexed(unique = true) //validação para deixar email como único
	@NotBlank(message = "Email Required") //não permite email nulo
	@Email(message = "Invalid Email") //deverá ser informado um email válido, com padrão de email
	private String email;
	
	@NotBlank(message = "Password required") //não permite senha nula
	@Size(min = 6) // tamanho mínimo da senha igual a 6
	private String password;
	
	private ProfileEnum profile; //perfil de acesso 

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
	
	
	
}
