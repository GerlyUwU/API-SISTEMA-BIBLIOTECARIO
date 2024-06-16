package com.uv.sistemaBibliotecario.Controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.model.Usuario;
import com.uv.sistemaBibliotecario.service.LibroService;
import com.uv.sistemaBibliotecario.service.UsuarioService;

@SpringBootTest
@AutoConfigureMockMvc
public class PrestamoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LibroService libroService;

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void realizarPrestamoTest() throws Exception {
        Libro libro = new Libro();
        libro.setIsbn("978-8478884457");
        libro.setTitulo("Harry Potter y la piedra filosofal");
        libro.setAutor("J.K. Rowling");
        libroService.agregarLibro(libro);

        Usuario usuario = new Usuario();
        usuario.setNombre("María Rodríguez");
        usuarioService.registrarUsuario(usuario);

        String jsonRequest = "{\"isbn\":\"978-8478884457\",\"usuarioId\":\"" + usuario.getId() + "\"}";

        mockMvc.perform(post("/api/prestamos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isCreated());
    }
}
