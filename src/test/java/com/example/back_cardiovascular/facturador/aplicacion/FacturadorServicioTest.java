package com.example.back_cardiovascular.facturador.aplicacion;

import com.example.back_cardiovascular.facturador.dominio.Facturador;
import com.example.back_cardiovascular.facturador.dominio.IFacturadorRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql-scripts/my-test-data.sql")

class FacturadorServicioTest {

    private FacturadorServicio facturadorServicio;
    private IFacturadorRepositorio facturadorRepositorioMock;

    @BeforeEach
    public void setUp() {
        facturadorRepositorioMock = Mockito.mock(IFacturadorRepositorio.class);
        facturadorServicio = new FacturadorServicio(facturadorRepositorioMock);
    }

    @Test
    public void testSaveFacturador() {
        // Arrange
        Facturador facturador = new Facturador();
        facturador.setNombre("Nombre");
        facturador.setApellidos("Apellidos");
        // Puedes continuar seteando los demás atributos del objeto Facturador según tus necesidades

        Mockito.when(facturadorRepositorioMock.save(facturador)).thenReturn(facturador);

        // Act
        boolean saved = facturadorServicio.save(facturador);

        // Assert
        Assertions.assertTrue(saved);
    }

    @Test
    public void testGetFacturadorById() {
        // Arrange
        Long facturadorId = 1L;
        Facturador facturador = new Facturador();
        facturador.setId(facturadorId);
        facturador.setNombre("Nombre");
        facturador.setApellidos("Apellidos");
        // Puedes continuar seteando los demás atributos del objeto Facturador según tus necesidades

        Mockito.when(facturadorRepositorioMock.findById(facturadorId)).thenReturn(Optional.of(facturador));

        // Act
        Optional<Facturador> result = facturadorServicio.get(facturadorId);

        // Assert
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(facturadorId, result.get().getId());
    }
}
