FROM openjdk:11-jdk-oraclelinux7

COPY . ./service

RUN cd service && ./mvnw clean install && cd ..

ARG JAR_FILE=service/target/*.jar
COPY ${JAR_FILE} ./app.jar

RUN rm -fr service

ENTRYPOINT ["java", "-jar", "/app.jar"]