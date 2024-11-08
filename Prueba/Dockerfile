# Usa una imagen base que contenga OpenJDK y Maven
FROM maven:3.8.1-openjdk-11 AS build

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y las carpetas necesarias para Maven
COPY pom.xml .
COPY .mvn .mvn

# Descarga las dependencias del proyecto
RUN ./mvnw dependency:go-offline

# Copia el resto de la aplicación
COPY src ./src

# Ejecuta el comando de construcción
RUN ./mvnw clean package

# Establece el puerto que se va a exponer
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/prueba.jar"]

