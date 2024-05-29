package com.uv.sistemaBibliotecario.repository;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.model.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}