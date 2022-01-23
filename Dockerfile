#
# Build stage
#
FROM maven:3.8.4-openjdk-17 AS build
COPY . /usr/local/src/asd-user-manager
RUN mvn -f /usr/local/src/asd-user-manager/pom.xml clean install

FROM openjdk:17-alpine
COPY --from=build /usr/local/src/asd-user-manager/target/usermanager-01.jar /usr/local/lib/usermanager-01.jar
ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","/usr/local/lib/usermanager-01.jar"]