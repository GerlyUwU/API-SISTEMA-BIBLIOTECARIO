package com.uv.sistemaBibliotecario.service;

import com.uv.sistemaBibliotecario.model.Libro;
import com.uv.sistemaBibliotecario.model.Prestamo;
import com.uv.sistemaBibliotecario.model.Usuario;
import com.uv.sistemaBibliotecario.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public Prestamo realizarPrestamo(Libro libro, Usuario usuario) {
        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);
        prestamo.setFechaPrestamo(LocalDate.now());
        return prestamoRepository.save(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamoRepository.save(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    public List<Prestamo> listarPrestamosDeUsuario(Usuario usuario) {
        return prestamoRepository.findByUsuario(usuario);
    }
}
