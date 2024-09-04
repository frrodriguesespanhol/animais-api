package com.example.fabio.animaisapi.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Cidade;

public interface CidadeRepository extends JpaRepository<com.example.fabio.animaisapi.model.Cidade, Long> {
		
	@Query(" select c from Cidade c where" +
			" upper(c.nome) like upper(:nome) and" +
			" cast( c.idPais.id as string) like :idPais" +
			" order by c.nome")
	Page<Cidade> buscarPorNomeCidade(
			@Param("nome") String nome,
			@Param("idPais") String idPais,
			Pageable pageable);
}