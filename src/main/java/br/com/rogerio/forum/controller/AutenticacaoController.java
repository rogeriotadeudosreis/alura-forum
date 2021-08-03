package br.com.rogerio.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerio.forum.config.security.TokenService;
import br.com.rogerio.forum.controller.dto.TokenDto;
import br.com.rogerio.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	// Esta injeção de pedendência é preciso criar o método AuthenticationManager na
	// classe SecurityConfigurations
	// Por algum motivo desconhecido, o spring não tem configurado a injeção de
	// dependência automática com @Autowired,
	// Conforme orientação do instrutor do curso Alura.
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = form.convert();

		try {

			Authentication authentication = authManager.authenticate(dadosLogin);
			
			String token = tokenService.gerarToken(authentication);
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
