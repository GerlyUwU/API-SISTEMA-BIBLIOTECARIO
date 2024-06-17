package com.uv.sistemaBibliotecario.Controller;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.service.LibroService;

@WebMvcTest(LibroController.class)
public class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Test
    void testAgregarLibro() throws Exception {
        Libro libro = new Libro();
        libro.setId("1");
        libro.setTitulo("Nuevo Libro");
        
        when(libroService.agregarLibro(any(Libro.class))).thenReturn(libro);

        mockMvc.perform(post("/api/libros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"titulo\": \"Nuevo Libro\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.titulo").value("Nuevo Libro"));

        verify(libroService, times(1)).agregarLibro(any(Libro.class));
    }

    @Test
    void testBuscarLibroPorISBN() throws Exception {
        Libro libro = new Libro();
        libro.setIsbn("1234567890");
        libro.setTitulo("Libro con ISBN");

        when(libroService.buscarLibroPorISBN("1234567890")).thenReturn(libro);

        mockMvc.perform(get("/api/libros/isbn/1234567890"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn").value("1234567890"))
                .andExpect(jsonPath("$.titulo").value("Libro con ISBN"));

        verify(libroService, times(1)).buscarLibroPorISBN("1234567890");
    }

    @Test
    void testBuscarLibroPorId() throws Exception {
        Libro libro = new Libro();
        libro.setId("1");
        libro.setTitulo("Libro con ID");

        when(libroService.buscarLibroPorId("1")).thenReturn(Optional.of(libro));

        mockMvc.perform(get("/api/libros/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.titulo").value("Libro con ID"));

        verify(libroService, times(1)).buscarLibroPorId("1");
    }

    @Test
    void testEliminarLibro() throws Exception {
        doNothing().when(libroService).eliminarLibro("1");

        mockMvc.perform(delete("/api/libros/1"))
                .andExpect(status().isNoContent());

        verify(libroService, times(1)).eliminarLibro("1");
    }

    @Test
    void testListarLibros() throws Exception {
        Libro libro1 = new Libro();
        libro1.setId("1");
        libro1.setTitulo("Libro 1");

        Libro libro2 = new Libro();
        libro2.setId("2");
        libro2.setTitulo("Libro 2");

        when(libroService.listarLibros()).thenReturn(Arrays.asList(libro1, libro2));

        mockMvc.perform(get("/api/libros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].titulo").value("Libro 1"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].titulo").value("Libro 2"));

        verify(libroService, times(1)).listarLibros();
    }
}
