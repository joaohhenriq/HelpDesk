package com.joaohenrique.HelpDesk.api.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joaohenrique.HelpDesk.api.enums.PriorityEnum;
import com.joaohenrique.HelpDesk.api.enums.StatusEnum;

@Document //para usar mongodb
public class Ticket {

	@Id
	private String id;
	
	@DBRef(lazy = true) //faz referência à coleção de usuários (USer) 
	private User user;
	
	private Date date; //data de abertura do ticket
	
	private String title; //titulo do ticket
	
	private Integer number; //número do ticket, para facilitar identificação do título, quando precisar pesquisar
	
	private StatusEnum status; //status atual do ticket
	
	private PriorityEnum priority; //prioridade do ticket
	
	@DBRef(lazy = true)
	private User assignedUser; //técnico que aceitará o ticket
	
	private String description; //descrição do ticket
	
	private String image; //imagem do erro/problema do ticket;
	
	@Transient //para não representar isso no banco de dados, seja ignorado, pois será trabalhado em tempo de execução
	private List<ChangeStatus> changes; //Lista com todas as alterações do status do ticket

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

	public Integer getNumber() {
		return number;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public PriorityEnum getPriority() {
		return priority;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public List<ChangeStatus> getChanges() {
		return changes;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setChanges(List<ChangeStatus> changes) {
		this.changes = changes;
	}
	
	
}
