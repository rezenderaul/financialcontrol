package com.raulrezende.financialcontrol.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raulrezende.financialcontrol.entities.Customer;
import com.raulrezende.financialcontrol.entities.dto.CustomerDTO;
import com.raulrezende.financialcontrol.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Transactional(readOnly = true)
	public List<CustomerDTO> findAll() {
		List<Customer> list = repository.findAll();
		return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
	}
}
