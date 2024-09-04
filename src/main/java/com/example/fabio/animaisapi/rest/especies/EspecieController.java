package com.example.fabio.animaisapi.rest.especies;

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


import com.example.fabio.animaisapi.model.Especie;
import com.example.fabio.animaisapi.model.repository.EspecieRepository;

@RestController
@RequestMapping("/api/especies")
@CrossOrigin("*")
public class EspecieController {

	@Autowired
	private EspecieRepository repository;

	@PostMapping
	public ResponseEntity salvar(@RequestBody EspecieFormRequest request) {
		Especie especie = request.toModel();
		System.out.println("Especie--> " + especie);
		repository.save(especie);
		return ResponseEntity.ok(EspecieFormRequest.fromModel(especie));
		
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Long id,
			@RequestBody EspecieFormRequest request) {

		Optional<Especie> especieExistente = repository.findById(id);
		if(especieExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Especie especie = request.toModel();
		especie.setId(id);
		repository.save(especie);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<EspecieFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map( EspecieFormRequest::fromModel )
				.map( especieFR -> ResponseEntity.ok(especieFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );				
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository
				.findById(id)
				.map( especie -> {
					repository.delete(especie);
					return ResponseEntity.noContent().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build()  );			
	}

	@GetMapping
	public Page<EspecieFormRequest> getLista(
		@RequestParam(value="nome", required= false, defaultValue = "") String nome,
		@RequestParam(value="idClassificacao", required= false, defaultValue = "") String idClassificacao,
		Pageable pageable
		
	){ //System.out.println(nome);
		return repository
				.buscarPorNome("%" + nome + "%", "%" + idClassificacao + "%", pageable)
					.map( EspecieFormRequest::fromModel );
	}
}