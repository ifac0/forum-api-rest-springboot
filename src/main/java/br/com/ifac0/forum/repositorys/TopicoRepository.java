package br.com.ifac0.forum.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifac0.forum.models.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	/**
	 * 	Caso exista atributo na modelo com esse nome se faz necessario usar 
	 *  o simbolo '_' para referenciar o relacionamento
	 *  
	 *	Exemplo: findByCurso_Nome
	 */	
	List<Topico> findByCursoNome(String nomeCurso);
	
	/**
	 * Forma de realizar uma consulta no banco de dados com Querys
	 *
	 * @Query("SELECT t FROM Topico WHERE t.curso.nome = :nomeCurso")
	 * List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	 */
}
