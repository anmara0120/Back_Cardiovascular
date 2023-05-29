package com.example.back_cardiovascular.paciente.infraestructura;

import com.example.back_cardiovascular.paciente.aplicacion.request.PacienteRequest;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.aplicacion.PacienteServicio;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Esta clase recibe la solicitud del front
 */
@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/paciente") // This means URL's start with /demo (after Application path)
public class PacienteControlador {

    /**
     * Es la variable que comunica  con el servicio
     */
    @Autowired
    private PacienteServicio service;

    /**
     * Este metodo recibe la identificacion del paciennte desde el front
     * luego se lo pasa al servicio
     * luego el servicio se lo pasa al repositorio
     * luego el repositorio le responde ese paciente al servicio
     * luego el servicio le envia el paciente al controlador
     * luego el controlador le envia el paciente al front
     * @param identificacion
     * @return paciente encontrado segun la identificacion que entro por parametro
     * La identificacion es la solicitud (request) y el paciente es la respuesta (response)
     */
    @SneakyThrows
    @GetMapping(path="/get")
    public @ResponseBody ResponseEntity<Paciente> getPatient (@RequestParam String identificacion) {
        Paciente paciente = service.getPatient(identificacion);

        return ResponseEntity.ok(paciente);
    }

    /**
     * Recibe el paciente desde el front y lo manda al servicio para que lo envie al repositorio y lo guarde
     * @param paciente
     * @return Responde estado  pero en este metodo retorna el paciente(Se debe quitar)
     */
    @SneakyThrows
    @PostMapping(path="/save")
    public @ResponseBody ResponseEntity<Paciente> savePatient (@RequestBody Paciente paciente) {
        log.info("Guardar paciente");
        return ResponseEntity.ok(service.savePatient(paciente));
    }

    /**
     * Este metodo recibe el paciente actualizado (update es actualizar)
     * @param pacienteRequest
     * @return
     */
    @SneakyThrows
    @PutMapping(path="/update")
    public @ResponseBody ResponseEntity<Paciente> updatePatient (@RequestBody Paciente pacienteRequest) {
        return ResponseEntity.ok(service.getPatient(pacienteRequest.getIdentificacion()));
    }
}
