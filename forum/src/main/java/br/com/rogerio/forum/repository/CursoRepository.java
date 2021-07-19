package br.com.rogerio.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogerio.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	public Curso findByNome(String nome);

}
