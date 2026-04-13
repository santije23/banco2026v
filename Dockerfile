# Etapa de construcción
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
# Copia el JAR de la etapa 'build' a la etapa actual
COPY --from=build /app/target/banco2026v.jar banco2026v.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","banco2026v.jar"]