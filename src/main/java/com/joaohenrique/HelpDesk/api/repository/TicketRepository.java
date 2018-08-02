package com.joaohenrique.HelpDesk.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.joaohenrique.HelpDesk.api.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
	// Interface para fazer as conexões com nosso banco de dados, passando qual
	// entidade queremos acessar, e o tipo do ID, que no nosso caso é uma String.

	// Pesquisa pelo ID do usuário
	// Objeto do tipo page, pois nos retorna uma paginação
	// Quando cliente abre a lista de tickets, apenas podemos listar os tickets
	// abertos por ele, por isso é do tipo pege, e por isso faz a pesquisa pelo Id
	// do mesmo (usuário logado - cliente)
	// Ordena por data de forma descrescente, disponibilizando os dados da forma que
	// o usuário já deve ver
	// O atributo Date é encontrado na entidade Ticket
	// Para fazer a peginação, precisa passar a a interface pageable
	// O Id é capturado conforme explicado no ChangeStatusRepository
	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);

	// Método com vários parâmetros de pesquisa
	// Todos os atributos passados se encontram na entidade Ticket
	//o titulo tem ignoreCase (não diferenciar maiúsculo de minúsculo) pois o usuário pode digitar de qualquer forma
	//status e priority não possuem por serem enums, o usuário não vai digitar
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String priority, Pageable pages);

	// Método para usar no caso do cliente que pode fazer a pesquisa com todos estes
	// parâmetros, mas deve ver somente os tickets relacionados à ele
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String priority, String userId, Pageable pages);

	// Método para usar no caso do técnico, que deseja ver todos os tickets que
	// estão sendo realizados por ele
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(
			String title, String status, String priority, Pageable pages);
	
	//Método para pesquisar pelo número do ticket, uma forma mais simples do que pesquisar por seu ID
	Page<Ticket> findByNumber(Integer number, Pageable pages);
}
