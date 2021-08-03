package br.com.rogerio.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.rogerio.forum.modelo.Topico;
import lombok.Data;

@Data
public class TopicoDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime dateCreate;

	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.title = topico.getTitulo();
		this.message = topico.getMensagem();
		this.dateCreate = topico.getDataCriacao();

	}

	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		return topicos.map(TopicoDto::new);
	}

}
