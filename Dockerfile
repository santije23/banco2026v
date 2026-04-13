FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY target/banco2026v.jar banco2026v.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","banco2026v.jar"]