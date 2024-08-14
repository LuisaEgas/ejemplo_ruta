FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/ruta-0.0.1.jar
COPY ${JAR_FILE} app_ruta.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_ruta.jar"]