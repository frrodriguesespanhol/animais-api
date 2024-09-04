package com.example.fabio.animaisapi.rest.grupos;

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

import com.example.fabio.animaisapi.model.Grupo;
import com.example.fabio.animaisapi.model.repository.GrupoRepository;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin("*")
public class GrupoController {

	@Autowired
	private GrupoRepository repository;

	@PostMapping
	public ResponseEntity salvar(@RequestBody GrupoFormRequest request) {
		Grupo grupo = request.toModel();
		repository.save(grupo);
		return ResponseEntity.ok(GrupoFormRequest.fromModel(grupo));
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Long id,
			@RequestBody GrupoFormRequest request) {

		Optional<Grupo> grupoExistente = repository.findById(id);
		if(grupoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Grupo grupo = request.toModel();
		grupo.setId(id);
		repository.save(grupo);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<GrupoFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map( GrupoFormRequest::fromModel )
				.map( grupoFR -> ResponseEntity.ok(grupoFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );				
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository
				.findById(id)
				.map( grupo -> {
					repository.delete(grupo);
					return ResponseEntity.noContent().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build()  );			
	}

	@GetMapping
	public Page<GrupoFormRequest> getLista(
		@RequestParam(value="nome", required= false, defaultValue = "") String nome,
		Pageable pageable

	){//System.out.println(nome);
		return repository
					.buscarPorNome("%" + nome + "%",pageable)
					.map( GrupoFormRequest::fromModel );
	}
}