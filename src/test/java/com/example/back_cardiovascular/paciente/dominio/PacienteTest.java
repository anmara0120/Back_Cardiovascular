package com.example.back_cardiovascular.paciente.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.cita.dominio.Estado;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class PacienteTest {
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNombre("John");
        paciente.setApellidos("Doe");
        paciente.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        paciente.setSexo("M");
        paciente.setDireccion("123 Main St");
        paciente.setTelefono("555-1234");
        paciente.setEmail("john.doe@example.com");
        paciente.setIdentificacion("123456789");
        paciente.setTipoIdentificacion("CC");
        paciente.setTipoSangre("O+");
        paciente.setEstadoCivil("Soltero");
        paciente.setEps("EPS001");
        paciente.setEtnia("Mestizo");
        paciente.setGenero("Masculino");
        paciente.setZonaResidencia("Urbana");
        paciente.setGruposPoblacionales("Ninguno");
        paciente.setOcupacion("Estudiante");

        paciente.setHistoriasClinicas(new ArrayList<>());
        paciente.setCitas(new ArrayList<>());
    }

    @Test
    public void testGettersAndSetters() {
        Assertions.assertEquals(1L, paciente.getId());
        Assertions.assertEquals("John", paciente.getNombre());
        Assertions.assertEquals("Doe", paciente.getApellidos());
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), paciente.getFechaNacimiento());
        Assertions.assertEquals("M", paciente.getSexo());
        Assertions.assertEquals("123 Main St", paciente.getDireccion());
        Assertions.assertEquals("555-1234", paciente.getTelefono());
        Assertions.assertEquals("john.doe@example.com", paciente.getEmail());
        Assertions.assertEquals("123456789", paciente.getIdentificacion());
        Assertions.assertEquals("CC", paciente.getTipoIdentificacion());
        Assertions.assertEquals("O+", paciente.getTipoSangre());
        Assertions.assertEquals("Soltero", paciente.getEstadoCivil());
        Assertions.assertEquals("EPS001", paciente.getEps());
        Assertions.assertEquals("Mestizo", paciente.getEtnia());
        Assertions.assertEquals("Masculino", paciente.getGenero());
        Assertions.assertEquals("Urbana", paciente.getZonaResidencia());
        Assertions.assertEquals("Ninguno", paciente.getGruposPoblacionales());
        Assertions.assertEquals("Estudiante", paciente.getOcupacion());
        Assertions.assertNotNull(paciente.getHistoriasClinicas());
        Assertions.assertNotNull(paciente.getCitas());
    }

    @Test
    public void testAddHistoriaClinica() {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setId(1L);
        historiaClinica.setDate(LocalDate.now());
        historiaClinica.setFamilyBackground("No significant family background");
        historiaClinica.setWeight(70.5f);
        historiaClinica.setHeight(175.2f);

        paciente.getHistoriasClinicas().add(historiaClinica);

        Assertions.assertEquals(1, paciente.getHistoriasClinicas().size());
        Assertions.assertTrue(paciente.getHistoriasClinicas().contains(historiaClinica));
    }

    @Test
    public void testRemoveHistoriaClinica() {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setId(1L);
        historiaClinica.setDate(LocalDate.now());
        historiaClinica.setFamilyBackground("No significant family background");
        historiaClinica.setWeight(70.5f);
        historiaClinica.setHeight(175.2f);

        paciente.getHistoriasClinicas().add(historiaClinica);
        paciente.getHistoriasClinicas().remove(historiaClinica);

        Assertions.assertEquals(0, paciente.getHistoriasClinicas().size());
        Assertions.assertFalse(paciente.getHistoriasClinicas().contains(historiaClinica));
    }

    @Test
    public void testAddCita() {
        Cita cita = new Cita();
        cita.setId(1L);
        cita.setDate(LocalDate.now());
        cita.setIntervaloHora("10:00 - 11:00");
        cita.setState(Estado.Confirmed);
        cita.setNote("Please bring your medical records");
        cita.setType("Regular check-up");
        cita.setLocation("Medical Center");

        paciente.getCitas().add(cita);

        Assertions.assertEquals(1, paciente.getCitas().size());
        Assertions.assertTrue(paciente.getCitas().contains(cita));
    }

    @Test
    public void testRemoveCita() {
        Cita cita = new Cita();
        cita.setId(1L);
        cita.setDate(LocalDate.now());
        cita.setIntervaloHora("10:00 - 11:00");
        cita.setState(Estado.Scheduled);
        cita.setNote("Please bring your medical records");
        cita.setType("Regular check-up");
        cita.setLocation("Medical Center");

        paciente.getCitas().add(cita);
        paciente.getCitas().remove(cita);

        Assertions.assertEquals(0, paciente.getCitas().size());
        Assertions.assertFalse(paciente.getCitas().contains(cita));
    }
}
