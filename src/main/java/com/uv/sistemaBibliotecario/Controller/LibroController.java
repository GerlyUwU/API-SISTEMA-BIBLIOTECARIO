package com.uv.sistemaBibliotecario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.agregarLibro(libro), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        return new ResponseEntity<>(libroService.listarLibros(), HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> buscarLibroPorISBN(@PathVariable String isbn) {
        Libro libro = libroService.buscarLibroPorISBN(isbn);
        return libro != null ? new ResponseEntity<>(libro, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable String id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
