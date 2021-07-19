package br.com.rogerio.forum.config.validacao;

import lombok.Data;

@Data
public class ErroDeFormularioDto {

	private String campo;
	private String erro;

	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

}
