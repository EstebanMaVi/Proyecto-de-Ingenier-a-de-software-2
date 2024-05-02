FROM openjdk:17-jdk-alpine
COPY target/usuarios-0.0.1-SNAPSHOT.jar usuarios-app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "usuarios-app.jar"]