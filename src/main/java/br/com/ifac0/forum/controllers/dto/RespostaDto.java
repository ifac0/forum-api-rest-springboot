package br.com.ifac0.forum.controllers.dto;

import java.time.LocalDateTime;

import br.com.ifac0.forum.models.Resposta;

public class RespostaDto {

		private Long id;
		private String mensagem;
		private LocalDateTime dataCriacao;
		private String nomeAutor;
		
		public RespostaDto(Resposta resposta) {
			this.id = resposta.getId();
			this.mensagem = resposta.getMensagem();
			this.dataCriacao = resposta.getDataCriacao();
			this.nomeAutor = resposta.getAutor().getNome();
		}

		public Long getId() {
			return id;
		}

		public String getMensagem() {
			return mensagem;
		}

		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public String getNomeAutor() {
			return nomeAutor;
		}
		
		
}
