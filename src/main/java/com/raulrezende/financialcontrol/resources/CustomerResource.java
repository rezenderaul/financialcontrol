package com.raulrezende.financialcontrol.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulrezende.financialcontrol.entities.dto.CustomerDTO;
import com.raulrezende.financialcontrol.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<CustomerDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
		CustomerDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
