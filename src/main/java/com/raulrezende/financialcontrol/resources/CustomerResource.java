package com.raulrezende.financialcontrol.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulrezende.financialcontrol.entities.Customer;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer(1L, "LUCAS", "RIBEIRO DUARTE", "lucas@lucas.com.br", "fV1%uUlI5"));
		list.add(new Customer(1L, "PEDRO", "NASCIMENTO SILVA", "carlos@carlos.com.br", "zV3%C20Pe"));
		list.add(new Customer(1L, "JOAO", "MARTINS COSTA", "jose@jose.com.br", "zK4@!3VWW"));
		list.add(new Customer(1L, "CARLOS", "TEIXEIRA FREITAS", "jose@jose.com.br", "rX2%&sx3*"));
		list.add(new Customer(1L, "MARCOS", "MEDEIROS GOMES", "luiz@luiz.com.br", "tU3%$8#7*"));
		return ResponseEntity.ok().body(list);
	}
}
