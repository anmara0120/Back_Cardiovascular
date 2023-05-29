package com.example.back_cardiovascular.paciente.aplicacion;

import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Esta clase es la que hace el llamado al repositorio recibe del controlador y envia al repositorio
 */
@Service
@RequiredArgsConstructor
public class PacienteServicio {

    private final IPacienteRepositorio patientRepository;

    /**
     * Recibe la id del paciente y esa id la manda al repositorio para que lo busque y traiga el paciente
     * @param id
     * @return
     */
    public Paciente getPatient(String id){
        return patientRepository.findByIdentificacion(id);
    }

    /**
     * Recibe el paciente y lo manda al paciente repositorio para que lo guarde
     * @param paciente
     * @return
     */
    public Paciente savePatient(Paciente paciente){
        return patientRepository.save(paciente);
    }
}
