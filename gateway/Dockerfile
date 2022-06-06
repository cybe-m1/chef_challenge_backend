FROM openjdk:11-jdk-oraclelinux7

COPY . ./service

RUN ./mvnw clean install

ARG JAR_FILE=service/target/*.jar
COPY ${JAR_FILE} ./app.jar

RUN rm -fr service

ENTRYPOINT ["java", "-jar", "/app.jar"]