package com.uv.sistemaBibliotecario.repository;

import com.uv.sistemaBibliotecario.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibroRepository extends MongoRepository<Libro, String> {
    Libro findByIsbn(String isbn);
}