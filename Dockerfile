FROM openjdk:21

WORKDIR /app

COPY target/sistemaBibliotecario-0.0.1-SNAPSHOT.jar /app
COPY src/main/resources/application.properties /app

EXPOSE 8080

CMD ["java", "-jar", "sistemaBibliotecario-0.0.1-SNAPSHOT.jar", "--spring.config.location=/app/application.properties"]
#your code is garbage