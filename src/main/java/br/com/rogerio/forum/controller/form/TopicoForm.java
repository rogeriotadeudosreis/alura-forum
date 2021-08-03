package br.com.rogerio.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.rogerio.forum.modelo.Curso;
import br.com.rogerio.forum.modelo.Topico;
import br.com.rogerio.forum.repository.CursoRepository;
import lombok.Data;

@Data
public class TopicoForm {
	
	@NotNull 
	@NotEmpty(message = "O preenchimento do campo título é obrigatório")
	@Size(min = 5, max = 30)
	private String title;
	@NotNull 
	@NotEmpty(message = "O preenchimento da campo mensagem é obrigatório")
	@Size(min = 5, max = 100)
	private String message;
	@NotNull 
	@NotEmpty(message = "O preenchimento do campo nomeCurso é obrigatório")
	@Size(min = 5, max = 30)
	private String nomeCurso;
	
	public Topico convert(CursoRepository cursoRepository) {
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		return new Topico(title, message, curso);
	}

}
