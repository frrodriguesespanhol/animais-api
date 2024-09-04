package com.example.fabio.animaisapi.model.repository;

import com.example.fabio.animaisapi.model.Classificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Long> {

	@Query(" select e from Especie e where" +
			" (upper(e.nome) like upper(:nome)) and" +
			" cast( e.idClassificacao.id as string) like :idClassificacao" +
			" order by e.nome")
	Page<Especie> buscarPorNome(
			@Param("nome") String nome,
			@Param("idClassificacao") String idClassificacao,
			Pageable pageable);
}