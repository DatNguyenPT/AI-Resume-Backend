# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /Eureka-Server

# If code is changed, dependencies will not be reinstall again (cacheable)
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run (JRE). Use runtime instead of the whole JDK
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /Eureka-Server/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
