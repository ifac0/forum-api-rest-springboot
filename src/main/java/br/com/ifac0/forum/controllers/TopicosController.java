package br.com.ifac0.forum.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ifac0.forum.controllers.dto.DetalhesTopicoDto;
import br.com.ifac0.forum.controllers.dto.TopicoDto;
import br.com.ifac0.forum.controllers.form.AtualizacaoTopicoForm;
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
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri =  uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	/**
	 * Caso o nome que se encontra no GetMapping seja diferente do parametro do método 
	 * se faz necessario informar o que vai vim da url;
	 * Exemplo: @PathVariable("id")
	 */
	@GetMapping("/{id}")
	public DetalhesTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesTopicoDto(topico);		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Topico topico = form.atualizar(id, topicoRepository);
		return ResponseEntity.ok(new TopicoDto(topico));
	}
}
