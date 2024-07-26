FROM maven:3.8.1-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-ea-17-jdk-slim AS run

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8000

CMD ["java", "-jar", "app.jar"]