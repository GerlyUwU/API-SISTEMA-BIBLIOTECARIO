
FROM openjdk:11


WORKDIR /app


COPY target/sistemaBibliotecario-0.0.1-SNAPSHOT.jar /app


EXPOSE 8080


CMD ["java", "-jar", "sistemaBibliotecario-0.0.1-SNAPSHOT.jar"]
 # tu codigo es basura 