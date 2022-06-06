FROM openjdk:11-jdk-oraclelinux7

COPY . ./service

RUN cd service && ./mvnw clean install && ./mvnw package && cd ..

RUN ls service/target

ARG JAR_FILE=service/target/*.jar
COPY service/target/*.jar app.jar

RUN rm -fr service

ENTRYPOINT ["java", "-jar", "/app.jar"]