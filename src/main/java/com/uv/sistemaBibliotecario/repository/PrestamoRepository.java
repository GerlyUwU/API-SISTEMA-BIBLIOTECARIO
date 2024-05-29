package com.uv.sistemaBibliotecario.repository;

import com.uv.sistemaBibliotecario.model.Prestamo;
import com.uv.sistemaBibliotecario.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    List<Prestamo> findByUsuario(Usuario usuario);
}