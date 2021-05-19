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

import com.raulrezende.financialcontrol.entities.Bank;
import com.raulrezende.financialcontrol.entities.dto.BankDTO;
import com.raulrezende.financialcontrol.repositories.BankRepository;
import com.raulrezende.financialcontrol.services.exceptions.DatabaseException;
import com.raulrezende.financialcontrol.services.exceptions.ResourceNotFoundException;

@Service
public class BankService {

	@Autowired
	private BankRepository repository;

	@Transactional(readOnly = true)
	public List<BankDTO> findAll() {
		List<Bank> list = repository.findAll();
		return list.stream().map(x -> new BankDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public BankDTO findById(Long id) {
		Optional<Bank> obj = repository.findById(id);
		Bank entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new BankDTO(entity);
	}

	@Transactional
	public BankDTO insert(BankDTO dto) {
		Bank entity = new Bank();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new BankDTO(entity);
	}
	
	@Transactional
	public BankDTO update(long id, BankDTO dto) {
		try {
			Bank entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new BankDTO(entity);
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
	
	private void copyDtoToEntity(BankDTO dto, Bank entity) {
		entity.setCod(dto.getCod());
		entity.setName(dto.getName());
		entity.setShortName(dto.getShortName());
		entity.setImage(dto.getImage());
	}
}
