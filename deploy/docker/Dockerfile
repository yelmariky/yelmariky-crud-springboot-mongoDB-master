FROM openjdk:8-jdk-alpine

WORKDIR /app
ADD poc-api*.jar poc-api.jar


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","poc-api.jar"]

## docker build . -t poc-api:v1