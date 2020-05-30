package br.com.ifac0.forum.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifac0.forum.models.Curso;
import br.com.ifac0.forum.models.Topico;

@RestController
public class TopicosController {
	
	@RequestMapping("/topicos")
	public List<Topico> lista(){
		Topico topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));
		
		return Arrays.asList(topico, topico, topico);
	}
}
