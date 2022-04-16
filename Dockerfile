FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/store-app-image.jar store-app-image.jar
ENTRYPOINT ["java", "-jar", "/store-app-image.jar"]