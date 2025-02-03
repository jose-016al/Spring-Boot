FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/spring-secure-api-0.0.1.jar
COPY ${JAR_FILE} tienda.jar
ENTRYPOINT ["java", "-jar", "tienda.jar"]