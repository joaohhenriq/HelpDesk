package com.joaohenrique.HelpDesk.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joaohenrique.HelpDesk.api.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	// Interface para fazer as conexões com nosso banco de dados, passando qual
	// entidade queremos acessar, e o tipo do ID, que no nosso caso é uma String.
	
	User findByEmail(String email);
	
	Optional<User> findById(String id);
	
}
