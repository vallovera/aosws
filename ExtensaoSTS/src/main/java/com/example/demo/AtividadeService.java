package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

public class AtividadeService {
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public Atividade buscar(Integer id) {
		return atividadeRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(0));
	}
	
	public List<Atividade> buscarPorNome(String nome) {
		return atividadeRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public List<Atividade> buscarTodos() {
		return atividadeRepository.findAll();
	}
	
	public Atividade salvar(Atividade cargo) {
		return atividadeRepository.save(cargo);
	}
	
	public Atividade alterar(Atividade cargo) {
		buscar(cargo.id);
		return atividadeRepository.save(cargo);
	}

	public void excluir(Integer id) {
		atividadeRepository.deleteById(id);
	}
}
