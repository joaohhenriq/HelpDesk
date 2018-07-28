package com.joaohenrique.HelpDesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.joaohenrique.HelpDesk.api.entity.User;
import com.joaohenrique.HelpDesk.api.enums.ProfileEnum;

//Classe factory, para converter nosso usuário no usuário reconhecido pelo Spring Security
public class JwtUserFactory {
	
	private JwtUserFactory() {
	}
	
	//gera/converte um JwtUser com base nos dados de um usuário 
	public static JwtUser creat(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
	}
	
	//converte o perfil do usuário para o formato utilizado pelo Spring Secutiry
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
