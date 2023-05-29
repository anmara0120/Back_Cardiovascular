package com.example.back_cardiovascular.enfermero.dominio;

import com.example.back_cardiovascular.cita.dominio.Cita;
import com.example.back_cardiovascular.historia_clinica.HistoriaClinica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class EnfermeroTest {
    private Enfermero enfermero;
    private List<Cita> citas;
    private List<HistoriaClinica> historiasClinicas;

    @BeforeEach
    public void setUp() {
        enfermero = new Enfermero();
        enfermero.setId(1L);
        enfermero.setNombre("John");
        enfermero.setApellidos("Doe");
        enfermero.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        enfermero.setSexo("M");
        enfermero.setTelefono("123456789");
        enfermero.setEmail("john.doe@example.com");
        enfermero.setIdentificacion("ABC123");
        enfermero.setTipoIdentificacion("CC");
        enfermero.setIps("IPS-001");
        enfermero.setEspecialidad("Cardiología");
        enfermero.setTarjetaProfesional("12345");
        enfermero.setContrasena("password");

        citas = new ArrayList<>();
        Cita cita1 = new Cita();
        cita1.setId(1L);
        cita1.setDate(LocalDate.of(2023, 6, 1));
        cita1.setIntervaloHora("10:00 - 11:00");
        citas.add(cita1);

        Cita cita2 = new Cita();
        cita2.setId(2L);
        cita2.setDate(LocalDate.of(2023, 6, 2));
        cita2.setIntervaloHora("14:00 - 15:00");
        citas.add(cita2);

        enfermero.setCitas(citas);

        historiasClinicas = new ArrayList<>();
        HistoriaClinica historiaClinica1 = new HistoriaClinica();
        historiaClinica1.setId(1L);
        historiaClinica1.setDate(LocalDate.of(2023, 6, 1));
        historiaClinica1.setFamilyBackground("No significant medical history");
        historiasClinicas.add(historiaClinica1);

        HistoriaClinica historiaClinica2 = new HistoriaClinica();
        historiaClinica2.setId(2L);
        historiaClinica2.setDate(LocalDate.of(2023, 6, 2));
        historiaClinica2.setFamilyBackground("Hypertension in family");
        historiasClinicas.add(historiaClinica2);

        enfermero.setMedicalHistories(historiasClinicas);
    }

    @Test
    public void testGettersAndSetters() {
        Assertions.assertEquals(1L, enfermero.getId());
        Assertions.assertEquals("John", enfermero.getNombre());
        Assertions.assertEquals("Doe", enfermero.getApellidos());
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), enfermero.getFechaNacimiento());
        Assertions.assertEquals("M", enfermero.getSexo());
        Assertions.assertEquals("123456789", enfermero.getTelefono());
        Assertions.assertEquals("john.doe@example.com", enfermero.getEmail());
        Assertions.assertEquals("ABC123", enfermero.getIdentificacion());
        Assertions.assertEquals("CC", enfermero.getTipoIdentificacion());
        Assertions.assertEquals("IPS-001", enfermero.getIps());
        Assertions.assertEquals("Cardiología", enfermero.getEspecialidad());
        Assertions.assertEquals("12345", enfermero.getTarjetaProfesional());
        Assertions.assertEquals("password", enfermero.getContrasena());
    }

    @Test
    public void testCitas() {
        Assertions.assertEquals(citas, enfermero.getCitas());
    }

    @Test
    public void testMedicalHistories() {
        Assertions.assertEquals(historiasClinicas, enfermero.getMedicalHistories());
    }
}
