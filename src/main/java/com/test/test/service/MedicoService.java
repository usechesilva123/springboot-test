package com.test.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.modelo.Medico;
import com.test.test.repositorio.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico create(Medico medico) {
		return medicoRepository.save(medico);		
	}
	
	public List<Medico> getMedicos() {
		return medicoRepository.findAll();		
	}
	
	public void delete(Medico medico) {
		medicoRepository.delete(medico);		
	}
	
	public Optional<Medico> findById(Long id) {
		return medicoRepository.findById(id);		
	}

}
