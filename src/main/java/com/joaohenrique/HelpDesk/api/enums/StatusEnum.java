package com.joaohenrique.HelpDesk.api.enums;

public enum StatusEnum {
	New, //Quando cliente acabou de criar ticket
	Assigned, // (designado) quando técnico aceita o ticket para ser corrigido
	Resolved, // (resolvido) técnico passa o ticket pra resolvido quando corrige o erro
	Approved, //
	Disapproved, //
	Closed; //depois que chamado foi aprovado, técnico pode fechar o mesmo
	
	//método apenas para passar uma string e obter um dos valores do enum
	public static StatusEnum getStatus(String status) {
		switch(status) {
		
		case "New" : return New;
		case "Assigned" : return Assigned;
		case "Resolved" : return Resolved;
		case "Approved" : return Approved;
		case "Disapproved" : return Disapproved;
		case "Closed" : return Closed;
		default : return New;
		}
	}
}
