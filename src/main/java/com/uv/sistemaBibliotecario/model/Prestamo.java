package com.uv.sistemaBibliotecario.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "prestamos")
public class Prestamo {
    @Id
    private String id;

    @DBRef
    private Libro libro;

    @DBRef
    private Usuario usuario;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}