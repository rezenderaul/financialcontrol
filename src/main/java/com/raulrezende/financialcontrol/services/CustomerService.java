package com.raulrezende.financialcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raulrezende.financialcontrol.entities.Customer;
import com.raulrezende.financialcontrol.entities.dto.CustomerDTO;
import com.raulrezende.financialcontrol.repositories.CustomerRepository;
import com.raulrezende.financialcontrol.services.exceptions.DatabaseException;
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

	@Transactional
	public CustomerDTO insert(CustomerDTO dto) {
		Customer entity = new Customer();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CustomerDTO(entity);
	}
	
	@Transactional
	public CustomerDTO update(long id, CustomerDTO dto) {
		try {
			Customer entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CustomerDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new DatabaseException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(CustomerDTO dto, Customer entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setPremium(dto.getPremium());
	}
}
