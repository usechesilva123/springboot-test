package com.test.test.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.test.modelo.Medico;

/**
 * @date 24/03/2021
 * Repositorio de medicos <<Acceso a datos>>
 * @author diego.useche
 */
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
