package com.uv.sistemaBibliotecario.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.model.Prestamo;
import com.uv.sistemaBibliotecario.model.Usuario;
import com.uv.sistemaBibliotecario.service.LibroService;
import com.uv.sistemaBibliotecario.service.PrestamoService;
import com.uv.sistemaBibliotecario.service.UsuarioService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Prestamo> realizarPrestamo(@RequestParam String isbn, @RequestParam String usuarioId) {
        Libro libro = libroService.buscarLibroPorISBN(isbn);
        Usuario usuario = usuarioService.buscarUsuarioPorID(usuarioId);
        if (libro == null || usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prestamoService.realizarPrestamo(libro, usuario), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<Void> devolverLibro(@PathVariable String id) {
        Prestamo prestamo = prestamoService.listarPrestamos().stream()
                .filter(p -> p.getId().equals(id) && p.getFechaDevolucion() == null)
                .findFirst()
                .orElse(null);
        if (prestamo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        prestamoService.devolverLibro(prestamo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> listarPrestamos() {
        return new ResponseEntity<>(prestamoService.listarPrestamos(), HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Prestamo>> listarPrestamosDeUsuario(@PathVariable String usuarioId) {
        Usuario usuario = usuarioService.buscarUsuarioPorID(usuarioId);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prestamoService.listarPrestamosDeUsuario(usuario), HttpStatus.OK);
    }
}
