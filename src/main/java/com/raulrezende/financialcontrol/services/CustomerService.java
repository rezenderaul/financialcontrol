package com.raulrezende.financialcontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raulrezende.financialcontrol.entities.Customer;
import com.raulrezende.financialcontrol.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return repository.findAll();
	}
}
