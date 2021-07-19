package br.com.rogerio.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.rogerio.forum.modelo.Topico;
import br.com.rogerio.forum.repository.TopicoRepository;
import lombok.Data;

@Data
public class UpdateTopicoForm {
	
	@NotNull 
	@NotEmpty(message = "O preenchimento do campo título é obrigatório")
	@Size(min = 5, max = 30)
	private String title;
	@NotNull 
	@NotEmpty(message = "O preenchimento da campo mensagem é obrigatório")
	@Size(min = 5, max = 100)
	private String message;
	
	public Topico update(Long id, TopicoRepository topicoRepository) {
		
		Topico topico = topicoRepository.findById(id).get();
		
		topico.setTitulo(this.title);
		topico.setMensagem(this.message);
		
		return topico;
	}	

}
