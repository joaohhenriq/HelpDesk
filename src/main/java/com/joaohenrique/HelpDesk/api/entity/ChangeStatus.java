package com.joaohenrique.HelpDesk.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joaohenrique.HelpDesk.api.enums.StatusEnum;

@Document //´para usar mongo
public class ChangeStatus {

	@Id
	private String id;
	
	@DBRef //para referenciar com a entidade Ticket
	private Ticket ticket; //ticket no qual teve seu status mudado
	
	@DBRef //para referenciar com a entidade User
	private User userChange; //para referenciar usuário que fez a mudança de status
	
	private Date dateChangeStatus; //data que foi alterado o status
	
	private StatusEnum status; //status que foi alterado no momento 

	public String getId() {
		return id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public User getUserChange() {
		return userChange;
	}

	public Date getDateChangeStatus() {
		return dateChangeStatus;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}

	public void setDateChangeStatus(Date dateChangeStatus) {
		this.dateChangeStatus = dateChangeStatus;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	
	
}
