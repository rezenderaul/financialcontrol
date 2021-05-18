package com.raulrezende.financialcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raulrezende.financialcontrol.entities.Customer;
import com.raulrezende.financialcontrol.entities.dto.CustomerDTO;
import com.raulrezende.financialcontrol.repositories.CustomerRepository;
import com.raulrezende.financialcontrol.services.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Transactional(readOnly = true)
	public List<CustomerDTO> findAll() {
		List<Customer> list = repository.findAll();
		return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CustomerDTO findById(Long id) {
		Optional<Customer> obj = repository.findById(id);
		Customer entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CustomerDTO(entity);
	}
}
