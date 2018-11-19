package com.example.demo;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value="/atividades")

public class AtividadeResource {

	@Autowired
	private AtividadeService atividadeService;

	@GetMapping(path = "{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(atividadeService.buscar(id));
	}
	
	@GetMapping(path = "/like/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		List<Atividade> atividades = atividadeService.buscarPorNome(nome);
		return !atividades.isEmpty() ? ResponseEntity.ok(atividades) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Integer id) {
		 atividadeService.excluir(id);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Atividade atividade) {
		Atividade atividadeSalvo = atividadeService.salvar(atividade);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(atividadeSalvo.id).toUri();
		return ResponseEntity.created(location).body(atividadeSalvo);
	}
	
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@Valid @RequestBody Atividade atividade) {
		atividadeService.alterar(atividade);
	}
}
