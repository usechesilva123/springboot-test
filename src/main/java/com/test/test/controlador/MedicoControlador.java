package com.test.test.controlador;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.modelo.Medico;
import com.test.test.service.MedicoService;


@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicoControlador {
	
	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	private ResponseEntity<Medico> guardar(@RequestBody Medico medico){
		Medico temp = medicoService.create(medico);
		
		try {
			return ResponseEntity.created(new URI("/medicos" + temp.getId())).body(temp);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	private ResponseEntity<List<Medico>> lista(){		
		try {
			return ResponseEntity.ok(medicoService.getMedicos());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping(path = {"/{id}"})
	private ResponseEntity<Optional<Medico>> listarId(@PathVariable("id") Long  id){		
		try {
			return ResponseEntity.ok(medicoService.findById(id));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping(path = {"/{id}"})
	private ResponseEntity<Void> delete(@PathVariable("id") Long  id){		
		try {
			medicoService.delete(medicoService.findById(id).get());
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}		
	}

}
