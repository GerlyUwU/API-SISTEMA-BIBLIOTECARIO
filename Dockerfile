# Usa una imagen base de Java con la versión que necesites
FROM openjdk:11

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR construido en la etapa de construcción a la imagen
COPY target/sistemaBibliotecario-0.0.1-SNAPSHOT.jar /app

# Expone el puerto en el que tu aplicación Spring Boot está escuchando
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor Docker se inicia
CMD ["java", "-jar", "sistemaBibliotecario-0.0.1-SNAPSHOT.jar"]
