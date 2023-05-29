package com.example.back_cardiovascular.facturador.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")
class FacturadorTest {
    private Facturador facturador;

    @BeforeEach
    public void setUp() {
        facturador = new Facturador();
        facturador.setId(1L);
        facturador.setNombre("John");
        facturador.setApellidos("Doe");
        facturador.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        facturador.setSexo("M");
        facturador.setTelefono("123456789");
        facturador.setEmail("john.doe@example.com");
        facturador.setIdentificacion("ABC123");
        facturador.setTipoIdentificacion("CC");
        facturador.setIps("IPS-001");
        facturador.setEspecialidad("Cardiología");
        facturador.setTarjetaProfesional("12345");
        facturador.setContrasena("password");
    }

    @Test
    public void testGettersAndSetters() {
        Assertions.assertEquals(1L, facturador.getId());
        Assertions.assertEquals("John", facturador.getNombre());
        Assertions.assertEquals("Doe", facturador.getApellidos());
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), facturador.getFechaNacimiento());
        Assertions.assertEquals("M", facturador.getSexo());
        Assertions.assertEquals("123456789", facturador.getTelefono());
        Assertions.assertEquals("john.doe@example.com", facturador.getEmail());
        Assertions.assertEquals("ABC123", facturador.getIdentificacion());
        Assertions.assertEquals("CC", facturador.getTipoIdentificacion());
        Assertions.assertEquals("IPS-001", facturador.getIps());
        Assertions.assertEquals("Cardiología", facturador.getEspecialidad());
        Assertions.assertEquals("12345", facturador.getTarjetaProfesional());
        Assertions.assertEquals("password", facturador.getContrasena());
    }
}
