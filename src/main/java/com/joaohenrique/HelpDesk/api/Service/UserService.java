package com.joaohenrique.HelpDesk.api.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.joaohenrique.HelpDesk.api.entity.User;

public interface UserService {

	User findByEmail(String email);
	
	User creatOrUpdate(User user);
	
	Optional<User> findById(String id);
	
	void delete(String id);
	
	//page é qual página queremos: 1ª página, 2ª... ; é o count é a qtde de registros por página
	Page<User> findAll(int page, int count); 
}
