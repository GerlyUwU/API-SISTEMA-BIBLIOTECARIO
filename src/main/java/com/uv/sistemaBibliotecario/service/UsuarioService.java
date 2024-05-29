package com.uv.sistemaBibliotecario.service;

import com.uv.sistemaBibliotecario.model.Usuario;
import com.uv.sistemaBibliotecario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorID(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}