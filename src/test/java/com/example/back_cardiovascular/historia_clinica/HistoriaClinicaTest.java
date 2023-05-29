package com.example.back_cardiovascular.historia_clinica;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.paciente.dominio.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class HistoriaClinicaTest {
    private HistoriaClinica historiaClinica;

    @BeforeEach
    public void setUp() {
        historiaClinica = new HistoriaClinica();
        historiaClinica.setId(1L);
        historiaClinica.setDate(LocalDate.of(2022, 9, 15));
        historiaClinica.setFamilyBackground("No significant family background");
        historiaClinica.setWeight(70.5f);
        historiaClinica.setHeight(175.2f);
        historiaClinica.setPaciente(new Paciente());
        historiaClinica.setEnfermero(new Enfermero());
    }

    @Test
    public void testGettersAndSetters() {
        Assertions.assertEquals(1L, historiaClinica.getId());
        Assertions.assertEquals(LocalDate.of(2022, 9, 15), historiaClinica.getDate());
        Assertions.assertEquals("No significant family background", historiaClinica.getFamilyBackground());
        Assertions.assertEquals(70.5f, historiaClinica.getWeight(), 0.001);
        Assertions.assertEquals(175.2f, historiaClinica.getHeight(), 0.001);
        Assertions.assertNotNull(historiaClinica.getPaciente());
        Assertions.assertNotNull(historiaClinica.getEnfermero());
    }
}
