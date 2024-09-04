package com.example.fabio.animaisapi.rest.classificacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fabio.animaisapi.model.Classificacao;
import com.example.fabio.animaisapi.model.repository.ClassificacaoRepository;

@RestController
@RequestMapping("/api/classificacoes")
@CrossOrigin("*")
public class ClassificacaoController {

	@Autowired
	private ClassificacaoRepository repository;

	@PostMapping
	public ResponseEntity salvar(@RequestBody ClassificacaoFormRequest request) {
		Classificacao classificacao = request.toModel();
		repository.save(classificacao);
		return ResponseEntity.ok(ClassificacaoFormRequest.fromModel(classificacao));
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Long id,
			@RequestBody ClassificacaoFormRequest request) {

		Optional<Classificacao> classificacaoExistente = repository.findById(id);
		if(classificacaoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Classificacao classificacao = request.toModel();
		classificacao.setId(id);
		repository.save(classificacao);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<ClassificacaoFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map( ClassificacaoFormRequest::fromModel )
				.map( classificacaoFR -> ResponseEntity.ok(classificacaoFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );				
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository
				.findById(id)
				.map( classificacao -> {
					repository.delete(classificacao);
					return ResponseEntity.noContent().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build()  );			
	}

	@GetMapping
	public Page<ClassificacaoFormRequest> getLista(
		@RequestParam(value="nome", required= false, defaultValue = "") String nome,
		@RequestParam(value="idGrupo", required= false, defaultValue = "") String idGrupo,
		Pageable pageable
	){
		System.out.println(idGrupo);
		return repository
					.buscarPorNome("%" + nome + "%", "%" + idGrupo + "%", pageable)
					.map( ClassificacaoFormRequest::fromModel );
	}
}