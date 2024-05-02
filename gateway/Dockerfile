FROM openjdk:17-jdk-alpine
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-app.jar"]