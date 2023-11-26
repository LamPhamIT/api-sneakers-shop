FROM openjdk:17-jdk-slim-buster
COPY target/sneakers-shop-0.0.1-SNAPSHOT.jar sneakers-shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/sneakers-shop-0.0.1-SNAPSHOT.jar"]
