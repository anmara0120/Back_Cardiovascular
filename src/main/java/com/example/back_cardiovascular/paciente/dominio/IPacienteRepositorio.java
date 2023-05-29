package com.example.back_cardiovascular.paciente.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *Es el que guarda el paicente en la base de datos
 */
@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Long> {
    Paciente findByIdentificacion(String id);
}
