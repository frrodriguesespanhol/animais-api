package com.example.fabio.animaisapi.model.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.fabio.animaisapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);
	
	@Query(" select u from Usuario u where upper(u.nome) like upper(:nome) ")
	Page<Usuario> buscarPorNome(
			@Param("nome") String nome,
			Pageable pageable);
}