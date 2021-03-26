package com.test.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test.modelo.Medico;
import com.test.test.repositorio.MedicoRepository;

/**
 * @date 24/03/2021
 * Servicio para entidad medico
 * @author diego.useche
 */
@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	/*
	 * Metodo encargado de guardar un medico
	 */
	public Medico create(Medico medico) {
		return medicoRepository.save(medico);		
	}
	
	/*
	 * Metodo encargado de obtener listado de medicos
	 */
	public List<Medico> getMedicos() {
		return medicoRepository.findAll();		
	}
	
	/*
	 * Metodo encargado de eliminar un medico
	 */
	public void delete(Medico medico) {
		medicoRepository.delete(medico);		
	}
	
	/*
	 * Metodo encargado de obtener un medico por id
	 */
	public Optional<Medico> findById(Long id) {
		return medicoRepository.findById(id);		
	}

}
