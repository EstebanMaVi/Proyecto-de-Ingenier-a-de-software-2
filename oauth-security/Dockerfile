FROM openjdk:17-jdk-alpine
COPY target/oauth-security-0.0.1-SNAPSHOT.jar oauth-app.jar
EXPOSE 8120
ENTRYPOINT ["java", "-jar", "oauth-app.jar"]