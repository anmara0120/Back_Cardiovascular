package com.example.back_cardiovascular.paciente.aplicacion;

import com.example.back_cardiovascular.paciente.dominio.Paciente;
import com.example.back_cardiovascular.paciente.dominio.IPacienteRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class PacienteServicioTest {

    @Mock
    private IPacienteRepositorio pacienteRepositorio;

    private PacienteServicio pacienteServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pacienteServicio = new PacienteServicio(pacienteRepositorio);
    }

    @Test
    void getPatient_DelegateToRepository() {
        // Arrange
        String id = "2";
        Paciente paciente = new Paciente();
        when(pacienteRepositorio.findByIdentificacion(id)).thenReturn(paciente);

        // Act
        Paciente result = pacienteServicio.getPatient(id);

        // Assert
        assertEquals(paciente, result);
        verify(pacienteRepositorio).findByIdentificacion(id);
    }

    @Test
    void savePatient_DelegateToRepository() {
        // Arrange
        Paciente paciente = new Paciente();
        when(pacienteRepositorio.save(paciente)).thenReturn(paciente);

        // Act
        Paciente result = pacienteServicio.savePatient(paciente);

        // Assert
        assertEquals(paciente, result);
        verify(pacienteRepositorio).save(paciente);
    }
}
