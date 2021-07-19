package br.com.rogerio.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogerio.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	// O método abaixo segue a nomenclatura padrão do Spring
	// Vantagem: o JPA monta a query JPQL automaticamente
	Page<Topico> findByCursoNome(String nomeCurso, Pageable page);
	
	// o exemplo de query abaixo é caso queiramos usar uma nomenclatura fora do padrão do Spring
	// Desvantagem: a query JPQL deve ser informada pelo desenvolvedor durante a implementação
//	@Query("SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso")
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

}
