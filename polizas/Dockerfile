FROM openjdk:17-jdk-alpine
COPY target/polizas-0.0.1-SNAPSHOT.jar polizas-app.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "polizas-app.jar"]