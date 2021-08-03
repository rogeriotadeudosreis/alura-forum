package br.com.rogerio.forum.controller.dto;

public class TokenDto {

	private String token;
	private String tipo;
	
	public TokenDto() {
		super();
	}

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setString(String tipo) {
		this.tipo = tipo;
	}
	

}
