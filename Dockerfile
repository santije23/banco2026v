FROM openjdk:17.0.1-jdk-slim
EXPOSE 8080
ADD target/banco2026v.jar banco2026v.jar
ENTRYPOINT ["java","-jar","banco2026v.jar"]