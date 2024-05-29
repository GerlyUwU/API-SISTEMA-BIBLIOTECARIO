package com.uv.sistemaBibliotecario.service;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro agregarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro buscarLibroPorISBN(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    public void eliminarLibro(String id) {
        libroRepository.deleteById(id);
    }
}