FROM maven:3.9.8-amazoncorretto-17 AS build
WORKDIR  /app
COPY . .
RUN mvn clean install

FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY --from=BUILD /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]