package com.uv.sistemaBibliotecario.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.repository.LibroRepository;

class LibroServiceTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroService libroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAgregarLibro() {
        Libro libro = new Libro();
        libro.setId("1");
        libro.setTitulo("El Quijote");

        when(libroRepository.save(libro)).thenReturn(libro);

        Libro resultado = libroService.agregarLibro(libro);

        assertNotNull(resultado);
        assertEquals("1", resultado.getId());
        assertEquals("El Quijote", resultado.getTitulo());
        verify(libroRepository, times(1)).save(libro);
    }

    @Test
    void testBuscarLibroPorISBN() {
        String isbn = "1234567890";
        Libro libro = new Libro();
        libro.setIsbn(isbn);

        when(libroRepository.findByIsbn(isbn)).thenReturn(libro);

        Libro resultado = libroService.buscarLibroPorISBN(isbn);

        assertNotNull(resultado);
        assertEquals(isbn, resultado.getIsbn());
        verify(libroRepository, times(1)).findByIsbn(isbn);
    }

    @Test
    void testBuscarLibroPorId() {
        String id = "1";
        Libro libro = new Libro();
        libro.setId(id);

        when(libroRepository.findById(id)).thenReturn(Optional.of(libro));

        Optional<Libro> resultado = libroService.buscarLibroPorId(id);

        assertTrue(resultado.isPresent());
        assertEquals(id, resultado.get().getId());
        verify(libroRepository, times(1)).findById(id);
    }

    @Test
    void testEliminarLibro() {
        String id = "1";

        doNothing().when(libroRepository).deleteById(id);

        libroService.eliminarLibro(id);

        verify(libroRepository, times(1)).deleteById(id);
    }

    @Test
    void testListarLibros() {
        List<Libro> libros = Arrays.asList(new Libro(), new Libro());

        when(libroRepository.findAll()).thenReturn(libros);

        List<Libro> resultado = libroService.listarLibros();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(libroRepository, times(1)).findAll();
    }
}
