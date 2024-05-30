package com.uv.sistemaBibliotecario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SistemaBibliotecarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaBibliotecarioApplication.class, args);
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public CommandLineRunner run(WebClient.Builder webClientBuilder) throws Exception {
        return args -> {
            WebClient webClient = webClientBuilder.baseUrl("http://localhost:8080").build();

            // Crear un libro
            Libro libro = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967);
            Libro nuevoLibro = webClient.post()
                    .uri("/api/libros")
                    .body(Mono.just(libro), Libro.class)
                    .retrieve()
                    .bodyToMono(Libro.class)
                    .block();
            System.out.println("Libro creado: " + nuevoLibro);

            // Obtener todos los libros
            Libro[] libros = webClient.get()
                    .uri("/api/libros")
                    .retrieve()
                    .bodyToMono(Libro[].class)
                    .block();
            System.out.println("Libros: " + Arrays.toString(libros));

            // Obtener un libro por ID
            Libro libroExistente = webClient.get()
                    .uri("/api/libros/{id}", nuevoLibro.getId())
                    .retrieve()
                    .bodyToMono(Libro.class)
                    .block();
            System.out.println("Libro obtenido: " + libroExistente);

            // Actualizar un libro
            libroExistente.setTitulo("Cien Años de Soledad - Edición Actualizada");
            webClient.put()
                    .uri("/api/libros/{id}", libroExistente.getId())
                    .body(Mono.just(libroExistente), Libro.class)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            System.out.println("Libro actualizado: " + libroExistente);

            // Eliminar un libro
            webClient.delete()
                    .uri("/api/libros/{id}", libroExistente.getId())
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            System.out.println("Libro eliminado.");
        };
    }
}

