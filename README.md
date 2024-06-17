# Proyecto Final: API REST Sistema Bibliotecario

## Descripción
Este proyecto consiste en el desarrollo de una API REST utilizando Spring Framework y MongoDB como base de datos NoSQL. El objetivo es crear una API que permita gestionar una biblioteca, manejando libros y usuarios, aplicando pruebas unitarias y realizando el despliegue automático de la aplicación.

## Objetivo General
Diseñar y crear una API REST utilizando métodos HTTP para manejar peticiones y códigos de respuesta HTTP para gestionar errores. La información se almacena en una base de datos NoSQL (MongoDB). Se aplican pruebas unitarias para asegurar el correcto funcionamiento de la aplicación y se implementa el despliegue automático.

## Objetivos Específicos
- Desarrollo de servicios web REST usando Spring Framework.
- Almacenamiento de información en una base de datos NoSQL MongoDB.
- Despliegue automático de la aplicación.

## Actividades Desarrolladas
- Configuración de Spring Framework y módulos Spring Boot para servicios web REST.
- Uso de métodos HTTP para manejar peticiones siguiendo las reglas RESTful.
- Creación de un manejador global de errores (ControllerAdvice) y uso de códigos de respuesta HTTP.
- Validación de información enviada por el cliente (Beans Validator).
- Negociación de contenido para que el cliente elija el formato de respuesta adecuado.
- Uso de Lombok y MapStruct para generación automática de código boilerplate.
- Uso de Spring Data JPA para creación de repositorios.
- Desarrollo de pruebas unitarias con JUnit 5.
- Generación de documentación de servicios web con Spring RestDocs.
- Uso de control de versiones con Git y GitHub.
- Contenerización de la aplicación con Docker y publicación en DockerHub.
- Despliegue automático con Jenkins.
- Elaboración de diagrama de despliegue.

## Checklist – Proyecto API REST

### Estructura Básica del Proyecto
- [x] Creado con Spring Initializer.
- [x] Aplicación ejecutable sin errores.

### Controladores y Manejo de Peticiones
- [x] Modelos representativos de la información.
- [x] Anotaciones correctas para métodos HTTP.
- [x] Respuestas vacías para servicios invocados.

### Validación y Manejo de Errores
- [x] Código de error para datos inválidos.
- [x] Descripción del error para datos incorrectos.
- [x] Manejo global de errores con descripción clara y códigos HTTP adecuados.

### Generación Automática de Código
- [x] Uso de getters y setters generados por Lombok.
- [x] Uso de constructores generados por Lombok.

### Conexión con MongoDB
- [x] Definición del modelo para la base de datos.
- [x] Lectura y escritura de información en MongoDB.

### Pruebas Unitarias
- [x] Pruebas exitosas (en verde) en el entorno de desarrollo.
- [x] Uso de TestRestTemplate para pruebas unitarias de servicios REST.

### Documentación de Servicios
- [x] Documentación accesible de los servicios web.

### Control de Versiones
- [x] Enlace al repositorio GitHub con todos los artefactos.
- [x] README.md con descripción detallada del proyecto.

### Contenerización con Docker
- [x] Dockerfile/Docker Compose para la imagen del proyecto.
- [x] Imagen registrada en DockerHub.
- [x] Descripción del proceso de recreación/ejecución del proyecto.

### Orquestación con Jenkins
- [x] Diagrama de pipeline de orquestación del proyecto.
- [x] Jenkinsfile y documentos para integración/despliegue continuo.


## Documentación de API
La documentación completa de la API, incluyendo detalles sobre endpoints, métodos HTTP, ejemplos de peticiones y respuestas, se encuentra disponible en [Postman](https://documenter.getpostman.com/view/35380043/2sA3XQiNfJ).

## Cómo Ejecutar el Proyecto


### Prerrequisitos
- JDK 21
- Maven
- MongoDB
- Docker

### Pasos para Ejecutar la Aplicación
1. **Configurar MongoDB** en tu entorno local o en la nube.

2. **Construir y ejecutar la aplicación:**
   ```bash
   mvn clean install
   mvn spring-boot:run


### Pasos para Ejecutar la Aplicación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/sistemaBibliotecario.git
   cd sistemaBibliotecario

## Para contenerizar y ejecutar con Docker

```bash
docker build -t sistema-bibliotecario .
docker run -p 8080:8080 sistema-bibliotecario
```

## Despliegue Automático con Jenkins

El proyecto está configurado para integración y despliegue continuo utilizando Jenkins. Asegúrate de tener Jenkins instalado y configurado en tu entorno. Configura el `Jenkinsfile` incluido en el repositorio para definir el pipeline de despliegue.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio importante.

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, ver el archivo `LICENSE` en el repositorio.




