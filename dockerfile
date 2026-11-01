# Etapa 1: Compilación usando Java 25
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src src

# Copiar el Maven wrapper
COPY mvnw .
COPY .mvn .mvn

# Dar permisos de ejecución al Maven wrapper y compilar
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final ligera de ejecución usando Java 25 JRE
FROM eclipse-temurin:25-jre
VOLUME /tmp

# Copiar el JAR resultante desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
