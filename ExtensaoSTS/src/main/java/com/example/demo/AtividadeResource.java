package com.example.demo;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/atividades")

public class AtividadeResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Atividade> lista()
	{
		
		Atividade a1 = new Atividade(1,"Visita técnica");
		
		return Arrays.asList(a1);
	}
}
