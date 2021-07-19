package br.com.rogerio.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rogerio.forum.modelo.StatusTopico;
import br.com.rogerio.forum.modelo.Topico;
import lombok.Data;

@Data
public class DetalhesDoTopicoDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime dateCreate;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> responses;

	public DetalhesDoTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.title = topico.getTitulo();
		this.message = topico.getMensagem();
		this.dateCreate = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.responses = new ArrayList<>();
		this.responses.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));

	}

}
