FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Ejercicio1-0.0.1.jar
COPY ${JAR_FILE} hello-contenedor.jar
ENTRYPOINT ["java", "-jar", "hello-contenedor.jar"]
