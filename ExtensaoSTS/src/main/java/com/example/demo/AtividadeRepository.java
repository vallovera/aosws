package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

	public List<Atividade> findByNomeContainingIgnoreCase(String nome);
}