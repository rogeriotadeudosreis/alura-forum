package br.com.rogerio.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.rogerio.forum.modelo.Resposta;
import lombok.Data;

@Data
public class RespostaDto {

	private Long id;
	private String message;
	private LocalDateTime dateCreate;
	private String nomeAutor;

	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.message = resposta.getMensagem();
		this.dateCreate = resposta.getDataCriacao();
		this.nomeAutor = resposta.getAutor().getNome();
	}

}
