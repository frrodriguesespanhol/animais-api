package com.example.fabio.animaisapi.rest.animais;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import com.example.fabio.animaisapi.model.Animais;
import com.example.fabio.animaisapi.model.repository.AnimaisRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/animais")
@CrossOrigin("*")
public class AnimaisController {

	@Autowired
	private AnimaisRepository repository;

	@PostMapping
	public ResponseEntity salvar(@RequestBody AnimaisFormRequest request) {
		Animais animais = request.toModel();
		//System.out.println(animais);
		repository.save(animais);
		return ResponseEntity.ok(AnimaisFormRequest.fromModel(animais));
	}

	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Long id,
			@RequestBody AnimaisFormRequest request) {

		Optional<Animais> animalExistente = repository.findById(id);
		if(animalExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Animais animais = request.toModel();
		animais.setId(id);
		repository.save(animais);
		return ResponseEntity.noContent().build();
	}

	//atualiza a foto1
	@PatchMapping("{id}")
	public ResponseEntity<Void> atualizarfoto1(
			@PathVariable Long id,
			@RequestBody AnimaisFormRequest request) {

		Optional<Animais> animalExistente = repository.findById(id);

		if(animalExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		System.out.println("animal existente: " +  animalExistente);

		Animais animais = request.toModel();

		System.out.println("animais tomodel: " +  animais);
		animais.setId(id);
		animais.setData(animalExistente.get().getData());
		animais.setIdGrupoAnimal(animalExistente.get().getIdGrupoAnimal());
		animais.setIdClassificacaoAnimal(animalExistente.get().getIdClassificacaoAnimal());
		animais.setIdEspecieAnimal(animalExistente.get().getIdEspecieAnimal());
		animais.setEspecie(animalExistente.get().getEspecie());
		animais.setLocalizacao(animalExistente.get().getLocalizacao());
		animais.setCadastradopor(animalExistente.get().getCadastradopor());
		animais.setEmail(animalExistente.get().getEmail());
		animais.setEstado(animalExistente.get().getEstado());
		animais.setComentario(animalExistente.get().getComentario());
		System.out.println("foto1: " +  animais.getFoto1());
		System.out.println("foto2: " +  animais.getFoto2());
		if (animais.getFoto1()!=null) {
			//animais.setFoto1(animalExistente.get().getFoto1());
			animais.setFoto2(animalExistente.get().getFoto2());
		}else {
			animais.setFoto1(animalExistente.get().getFoto1());
			//animais.setFoto2(animalExistente.get().getFoto2());
		}

		System.out.println("animais : " +  animais);
		repository.save(animais);
		return ResponseEntity.noContent().build();
	}


	@GetMapping("{id}")
	public ResponseEntity<AnimaisFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map( AnimaisFormRequest::fromModel )
				.map( animaisFR -> ResponseEntity.ok(animaisFR) )
				.orElseGet( () -> ResponseEntity.notFound().build()  );
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository
				.findById(id)
				.map( animais -> {
					repository.delete(animais);
					return ResponseEntity.noContent().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build()  );			
	}

	@GetMapping
	public Page<AnimaisFormRequest> getLista(
		@RequestParam(value="grupo", required= false, defaultValue = "") String grupo,
		@RequestParam(value="classificacao", required= false, defaultValue = "") String classificacao,
		@RequestParam(value="especie", required= false, defaultValue = "") String especie,
		Pageable pageable
	){
		return repository
					.buscarPorGrupoClassificacaoEspecie( grupo , classificacao , especie , pageable)
					.map( AnimaisFormRequest::fromModel );
	}
}