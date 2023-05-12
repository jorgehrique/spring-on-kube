FROM maven:3.8.3-openjdk-17 AS build
MAINTAINER jorgehasd@gmail.com
ADD ./pom.xml pom.xml
ADD ./src src/
RUN mvn install

FROM eclipse-temurin:17-alpine
COPY --from=build target/frase-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080