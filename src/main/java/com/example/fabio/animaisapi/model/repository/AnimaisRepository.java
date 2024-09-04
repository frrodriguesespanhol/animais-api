package com.example.fabio.animaisapi.model.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.el.util.ReflectionUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Animais;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Map;

public interface AnimaisRepository extends JpaRepository<Animais, Long> {
	
	@Query(" select a from Animais a Where"
			+ " (:idGrupoAnimal='' or cast(a.idGrupoAnimal.id as string) = :idGrupoAnimal) and "
			+ " (:idClassificacaoAnimal='' or (cast(a.idClassificacaoAnimal.id as string) = :idClassificacaoAnimal) and "
			+ " (:idEspecieAnimal='' or (cast(a.idEspecieAnimal.id as string) = :idEspecieAnimal))) order by a.data desc")

	Page<Animais> buscarPorGrupoClassificacaoEspecie(
			@Param("idGrupoAnimal") String idGrupoAnimal,
			@Param("idClassificacaoAnimal") String idClassificacaoAnimal,
			@Param("idEspecieAnimal") String idEspecieAnimal,
			Pageable pageable);


}


