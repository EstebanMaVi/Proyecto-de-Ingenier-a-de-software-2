FROM openjdk:17-jdk-alpine
COPY target/pasarela-pago-0.0.1-SNAPSHOT.jar pasarela-app.jar
EXPOSE 8035
ENTRYPOINT ["java", "-jar", "pasarela-app.jar"]