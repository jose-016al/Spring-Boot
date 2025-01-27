FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Ejercicio2-0.0.1.jar
COPY ${JAR_FILE} veterinaria.jar
ENTRYPOINT ["java", "-jar", "veterinaria.jar"]
