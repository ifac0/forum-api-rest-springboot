package br.com.ifac0.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifac0.forum.controllers.dto.TopicoDto;
import br.com.ifac0.forum.models.Curso;
import br.com.ifac0.forum.models.Topico;
import br.com.ifac0.forum.repositorys.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso){	
		if(nomeCurso == null) {
			List<Topico> listTopicos = topicoRepository.findAll();
			return TopicoDto.converter(listTopicos);
		}
		List<Topico> listTopicos = topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDto.converter(listTopicos);
	}
}
