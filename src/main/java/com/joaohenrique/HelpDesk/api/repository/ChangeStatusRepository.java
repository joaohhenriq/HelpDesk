package com.joaohenrique.HelpDesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joaohenrique.HelpDesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
	// Interface para fazer as conexões com nosso banco de dados, passando qual
	// entidade queremos acessar, e o tipo do ID, que no nosso caso é uma String.

	// método para buscar todas as alterações de um determinado ticket, apenas
	// O método pega o Id do ticket, devido ao atributo Ticket da entidade
	// ChangeStatus fazer referência à entidade Ticket, então pega o Id da entidade
	// Ticket, que está dentro da entidade ChangeStatus
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
