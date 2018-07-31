package com.joaohenrique.HelpDesk.api.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.joaohenrique.HelpDesk.api.entity.ChangeStatus;
import com.joaohenrique.HelpDesk.api.entity.Ticket;

@Component // para informar que essa classe será gerenciada pelo Spring
public interface TicketService {

	// Se o Id tiver preenchido, faz a alteração, caso contrário, inclui
	Ticket createOrUpdate(Ticket ticket);

	Optional<Ticket> findById(String id);

	void delete(String id);

	Page<Ticket> listTicket(int page, int count);

	// grava as alterações de status feito no ticket
	ChangeStatus createChangeStatus(ChangeStatus changeStatus);

	// retorna lista das alterações feitas em um ticket
	Iterable<ChangeStatus> listChangeStatus(String ticketId);

	// método para trazer os tickets somente do cliente logado
	Page<Ticket> findByCurrentUSer(int page, int count, String userId);

	// pode pesquisar por vários parâmetros diferentes
	Page<Ticket> findByParameters(int page, int count, String title, String status, String priority);

	// pode pesquisar por vários parâmetros diferentes, mas filtrando por usuário
	Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority);

	Page<Ticket> findByNumber(int page, int count, Integer number);

	Iterable<Ticket> findAll();

	Page<Ticket> findByParameterAndAssignedUSer(int page, int count, String title, String status, String priority,
			String assignedUser);
}
