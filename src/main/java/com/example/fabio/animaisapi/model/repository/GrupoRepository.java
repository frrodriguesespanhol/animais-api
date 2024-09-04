package com.example.fabio.animaisapi.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	@Query(" select g from Grupo g where upper(g.nome) like upper(:nome) ")
	Page<Grupo> buscarPorNome(
			@Param("nome") String nome,
			Pageable pageable);
}