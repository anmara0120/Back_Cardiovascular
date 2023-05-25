package com.example.back_cardiovascular.enfermero.infraestructura;

import com.example.back_cardiovascular.enfermero.aplicacion.request.EnfermeroRequest;
import com.example.back_cardiovascular.enfermero.aplicacion.EnfermeroServicio;
import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.authentication.dominio.LoginRequest;
import com.example.back_cardiovascular.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path="/enfermero") // This means URL's start with /demo (after Application path)
public class EnfermeroControlador {

    private final EnfermeroServicio service;
    @SneakyThrows
    @GetMapping(path="/get")
    public @ResponseBody ResponseEntity obtenerEnfermero (@RequestBody String identificacion) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ResponseEntity<?> finalResponse;
        MessageResponse message = new MessageResponse();
        if (identificacion == null) {
            return new ResponseEntity<>(message.apply("Debe agregar los datos de ingreso"), HttpStatus.BAD_REQUEST);
        }
        Enfermero enfermero = service.get(identificacion);
        finalResponse = enfermero == null ? new ResponseEntity<>(message.apply("El usuario no existe"), HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(enfermero, HttpStatus.OK);
        return finalResponse;
    }

    @SneakyThrows
    @PostMapping(path="/save")
    public @ResponseBody ResponseEntity guardarEnfermero(@RequestBody Enfermero enfermero) {
        System.out.println(enfermero);
        ResponseEntity<?> finalResponse;
        MessageResponse message = new MessageResponse();
        if (enfermero.getIdentificacion() == null) {
            return new ResponseEntity<>(message.apply("Debe agregar los datos de ingreso"), HttpStatus.BAD_REQUEST);
        }

        finalResponse = service.save(enfermero) ? new ResponseEntity<>(message.apply("Usuario creado satisfactoriamente"), HttpStatus.CREATED) :
                new ResponseEntity<>(message.apply("Message:Usuario ya existente"), HttpStatus.LOCKED);
        return finalResponse;
    }
}
