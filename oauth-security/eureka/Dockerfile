FROM openjdk:17-jdk-alpine
COPY target/eureka-0.0.1-SNAPSHOT.jar eureka-app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-app.jar"]