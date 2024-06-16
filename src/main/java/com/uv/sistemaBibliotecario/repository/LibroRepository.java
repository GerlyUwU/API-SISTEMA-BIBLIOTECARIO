package com.uv.sistemaBibliotecario.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uv.sistemaBibliotecario.model.Libro;

public interface LibroRepository extends MongoRepository<Libro, String> {
    Libro findByIsbn(String isbn);
    Optional<Libro> findById(String id); 
}