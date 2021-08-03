package br.com.rogerio.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.rogerio.forum.modelo.Usuario;
import br.com.rogerio.forum.repository.UsuarioRepository;

/*
 *  Este classe é a responsável por recuperar e validar o token gerado, conforme aula anterior.
 *   
 *  Conforme a configuração na classe SecurityConfigurations, a cada requisição, deve ser enviado
 *  o token no header da requisição.
 *  A idéia é que esta recuperação seja feita antes da requisição chegar em nossa AutenticacaoController.
 *  
 */

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
	private UsuarioRepository repository;

	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// Recuperando o token
		String token = this.recuperarToken(request);
		
		// Validando o token
		boolean valido = tokenService.isTokenValido(token);
		
		if (valido) {
			autenticarCliente(token);
		}
	
		// filtrando cada requisição
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}
}
