package br.com.ifac0.forum.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifac0.forum.models.Curso;
import br.com.ifac0.forum.models.Topico;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
