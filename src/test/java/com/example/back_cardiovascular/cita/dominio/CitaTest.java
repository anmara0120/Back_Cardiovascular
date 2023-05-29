package com.example.back_cardiovascular.cita.dominio;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class CitaTest {

    @Test
    void createCita_ValidData_CitaCreatedSuccessfully() {
        // Arrange
        LocalDate date = LocalDate.now();
        String intervaloHora = "10:00 - 11:00";
        Estado state = Estado.Scheduled;
        String note = "Nota de prueba";
        String type = "Tipo de cita";
        String location = "Ubicación de la cita";
        Enfermero enfermero = new Enfermero();
        Paciente paciente = new Paciente();

        // Act
        Cita cita = new Cita();
        cita.setDate(date);
        cita.setIntervaloHora(intervaloHora);
        cita.setState(state);
        cita.setNote(note);
        cita.setType(type);
        cita.setLocation(location);
        cita.setEnfermero(enfermero);
        cita.setPaciente(paciente);

        // Assert
        assertNotNull(cita);
        assertEquals(date, cita.getDate());
        assertEquals(intervaloHora, cita.getIntervaloHora());
        assertEquals(state, cita.getState());
        assertEquals(note, cita.getNote());
        assertEquals(type, cita.getType());
        assertEquals(location, cita.getLocation());
        assertEquals(enfermero, cita.getEnfermero());
        assertEquals(paciente, cita.getPaciente());
    }

    @Test
    void createCita_DefaultValues_CitaCreatedWithDefaultValues() {
        // Arrange

        // Act
        Cita cita = new Cita();

        // Assert
        assertNotNull(cita);
        assertEquals(null, cita.getDate());
        assertEquals(null, cita.getIntervaloHora());
        assertEquals(null, cita.getState());
        assertEquals(null, cita.getNote());
        assertEquals(null, cita.getType());
        assertEquals(null, cita.getLocation());
        assertEquals(null, cita.getEnfermero());
        assertEquals(null, cita.getPaciente());
    }
}
