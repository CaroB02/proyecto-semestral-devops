# --- Stage 1: Build ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo pom.xml para descargar dependencias primero y optimizar capas
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar el archivo .jar sin ejecutar los tests
COPY src ./src
RUN mvn package -DskipTests

# --- Stage 2: Production ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear un usuario no-root por motivos de seguridad y mínimo privilegio
RUN addgroup -S spring && adduser -S spring -G spring

# Copiar el archivo JAR generado en la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Cambiar al usuario de bajos privilegios
USER spring:spring

# Exponer el puerto interno por defecto de Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]