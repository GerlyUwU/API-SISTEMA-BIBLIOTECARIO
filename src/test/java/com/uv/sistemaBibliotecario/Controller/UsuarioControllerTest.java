package com.uv.sistemaBibliotecario.Controller;

import java.util.Arrays;

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

import com.uv.sistemaBibliotecario.model.Usuario;
import com.uv.sistemaBibliotecario.service.UsuarioService;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void testRegistrarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId("1");
        usuario.setNombre("Nuevo Usuario");
        
        when(usuarioService.registrarUsuario(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\": \"Nuevo Usuario\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nombre").value("Nuevo Usuario"));

        verify(usuarioService, times(1)).registrarUsuario(any(Usuario.class));
    }

    @Test
    void testBuscarUsuarioPorID() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId("1");
        usuario.setNombre("Usuario con ID");

        when(usuarioService.buscarUsuarioPorID("1")).thenReturn(usuario);

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nombre").value("Usuario con ID"));

        verify(usuarioService, times(1)).buscarUsuarioPorID("1");
    }

    @Test
    void testEliminarUsuario() throws Exception {
        doNothing().when(usuarioService).eliminarUsuario("1");

        mockMvc.perform(delete("/api/usuarios/1"))
                .andExpect(status().isNoContent());

        verify(usuarioService, times(1)).eliminarUsuario("1");
    }

    @Test
    void testListarUsuarios() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setId("1");
        usuario1.setNombre("Usuario 1");

        Usuario usuario2 = new Usuario();
        usuario2.setId("2");
        usuario2.setNombre("Usuario 2");

        when(usuarioService.listarUsuarios()).thenReturn(Arrays.asList(usuario1, usuario2));

        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Usuario 1"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].nombre").value("Usuario 2"));

        verify(usuarioService, times(1)).listarUsuarios();
    }
}
