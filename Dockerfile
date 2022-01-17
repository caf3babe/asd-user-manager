#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /src/asd-user-manager

RUN mvn -f /src/asd-user-manager/pom.xml clean install
