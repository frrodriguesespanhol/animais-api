package com.example.fabio.animaisapi.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {
	
	@Query(" select c from Classificacao c where" +
			" (upper(c.nome) like upper(:nome)) and" +
			" cast( c.idGrupo.id as string) like :idGrupo" +
			" order by c.nome")

	Page<Classificacao> buscarPorNome(
			@Param("nome") String nome,
			@Param("idGrupo") String idGrupo,
			Pageable pageable);
}