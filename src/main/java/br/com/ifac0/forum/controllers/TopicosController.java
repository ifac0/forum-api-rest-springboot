package br.com.ifac0.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifac0.forum.controllers.dto.TopicoDto;
import br.com.ifac0.forum.controllers.form.TopicoForm;
import br.com.ifac0.forum.models.Curso;
import br.com.ifac0.forum.models.Topico;
import br.com.ifac0.forum.repositorys.CursoRepository;
import br.com.ifac0.forum.repositorys.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso){	
		if(nomeCurso == null) {
			List<Topico> listTopicos = topicoRepository.findAll();
			return TopicoDto.converter(listTopicos);
		}
		List<Topico> listTopicos = topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDto.converter(listTopicos);
	}
	
	@PostMapping
	@RequestMapping("/topicos")
	public void cadastrar(@RequestBody TopicoForm form) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
	}
}
