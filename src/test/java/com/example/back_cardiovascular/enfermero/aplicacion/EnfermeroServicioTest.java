package com.example.back_cardiovascular.enfermero.aplicacion;

import com.example.back_cardiovascular.enfermero.dominio.Enfermero;
import com.example.back_cardiovascular.enfermero.dominio.IEnfermeroRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnfermeroServicioTest {

    @Mock
    private IEnfermeroRepositorio enfermeroRepositorio;

    private EnfermeroServicio enfermeroServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        enfermeroServicio = new EnfermeroServicio(enfermeroRepositorio);
    }

    @Test
    void save_ValidEnfermero_ReturnsTrue() {
        // Arrange
        Enfermero enfermero = new Enfermero();
        when(enfermeroRepositorio.save(enfermero)).thenReturn(enfermero);

        // Act
        boolean result = enfermeroServicio.save(enfermero);

        // Assert
        assertTrue(result);
        verify(enfermeroRepositorio).save(enfermero);
    }

    @Test
    void save_InvalidEnfermero_ReturnsFalse() {
        // Arrange
        Enfermero enfermero = new Enfermero();
        when(enfermeroRepositorio.save(enfermero)).thenReturn(null);

        // Act
        boolean result = enfermeroServicio.save(enfermero);

        // Assert
        assertFalse(result);
        verify(enfermeroRepositorio).save(enfermero);
    }

    @Test
    void get_ExistingId_ReturnsEnfermero() {
        // Arrange
        String id = "999";
        Enfermero enfermero = new Enfermero();
        when(enfermeroRepositorio.findByIdentificacion(id)).thenReturn(enfermero);

        // Act
        Enfermero result = enfermeroServicio.get(id);

        // Assert
        assertEquals(enfermero, result);
        verify(enfermeroRepositorio).findByIdentificacion(id);
    }

    @Test
    void get_NonExistingId_ReturnsNull() {
        // Arrange
        String id = "123";
        when(enfermeroRepositorio.findByIdentificacion(id)).thenReturn(null);

        // Act
        Enfermero result = enfermeroServicio.get(id);

        // Assert
        assertNull(result);
        verify(enfermeroRepositorio).findByIdentificacion(id);
    }

    @Test
    void getAll_ReturnsListOfEnfermeros() {
        // Arrange
        List<Enfermero> enfermeros = Arrays.asList(new Enfermero(), new Enfermero());
        when(enfermeroRepositorio.findAll()).thenReturn(enfermeros);

        // Act
        List<Enfermero> result = enfermeroServicio.getAll();

        // Assert
        assertEquals(enfermeros, result);
        verify(enfermeroRepositorio).findAll();
    }
}
