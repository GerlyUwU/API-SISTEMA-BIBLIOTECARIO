package com.uv.sistemaBibliotecario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SistemaBibliotecarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaBibliotecarioApplication.class, args);
        System.out.println("______________________________________________________________________________");
        System.out.println("LA API SE ESTA EJECUTANDO, COMPRUEBA EL PUERTO 8080 EN EL NAVEGADOR PARA MAS INFORMACION");
        System.out.println("______________________________________________________________________________");
    }

   
}

