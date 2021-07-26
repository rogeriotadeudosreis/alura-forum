package br.com.rogerio.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("br.com.rogerio.forum")
@EnableSpringDataWebSupport // módulo para habilitar o suprote de paginação e ordenação da classe Pageable
@EnableCaching // módulo para habilitar o cache no controler
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
		
			System.out.println("Senha criptografada para testes: " + new BCryptPasswordEncoder().encode("123456"));
	}

}
