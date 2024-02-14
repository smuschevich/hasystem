# build stage
FROM maven:3.8.5-openjdk-17-slim AS build

# create app directory
WORKDIR /home/app

COPY src src
COPY pom.xml pom.xml
RUN mvn clean package

# runtime stage
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /home/app/target/hasystem-api-gw-*.jar /usr/local/lib/hasystem-api-gw.jar
ENTRYPOINT java -jar /usr/local/lib/hasystem-api-gw.jar
