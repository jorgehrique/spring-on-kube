FROM maven:3.8.3-openjdk-17 AS build
MAINTAINER jorgehasd@gmail.com
ADD ./pom.xml pom.xml
ADD ./src src/
RUN mvn clean package

FROM eclipse-temurin:17-alpine
COPY --from=build target/calculadora-service-0.0.1-SNAPSHOT.jar calculadora-service-0.0.1-SNAPSHOT.jar
COPY target/calculadora-service-0.0.1-SNAPSHOT.jar calculadora-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/calculadora-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080