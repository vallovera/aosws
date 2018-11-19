package com.ExtensaoTests.Repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Atividade;
import com.example.demo.AtividadeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtividadeRepositoryTest {

	@Autowired
	private AtividadeRepository repository;

	@Test
	public void verificaQuantidadeAtividadesCadastradas() {
		Page<Atividade> atividades = this.repository.findAll(PageRequest.of(0, 10));
		assertThat(atividades.getTotalElements()).isGreaterThan(1);
	}
	
	@Test
	public void findByNome() {
		List<Atividade> atividades = this.repository.findByNomeContainingIgnoreCase("GDG");
		assertThat(atividades.size()).isEqualTo(1);
	}
	
	@Test 
	public void find() {
		List<Atividade> atividades = this.repository.findByNomeContainingIgnoreCase("Carlos");
		assertThat(atividades.size()).isEqualTo(0);
	}
	
	@Test
	public void saveTest() {
		Atividade atividade = new Atividade(0, "Test save repository");
		Atividade atividadeSalvo = this.repository.save(atividade);
		assertThat(atividadeSalvo.id).isNotNull();
	}
	
	@Test
	public void updateTest() {
		Atividade atividade = new Atividade(3, "Test Update repository");
		Atividade atividadeSalvo = this.repository.save(atividade);
		assertThat(atividadeSalvo.nome).containsIgnoringCase("repository");
	}
	
	@Test
	public void deleteTest() {
		Atividade atividade = new Atividade(3, "Test delete repository");
		this.repository.delete(atividade);
		
		Optional<Atividade> atividadeExcluida = this.repository.findById(atividade.id);
		assertThat(atividadeExcluida).isNotPresent();
	}
}
