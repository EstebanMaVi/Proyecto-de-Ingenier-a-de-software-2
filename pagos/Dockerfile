FROM openjdk:17-jdk-alpine
COPY target/pagos-0.0.1-SNAPSHOT.jar pagos-app.jar
EXPOSE 8050
ENTRYPOINT ["java", "-jar", "pagos-app.jar"]