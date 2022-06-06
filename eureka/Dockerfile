FROM openjdk:11-jdk-oraclelinux7

COPY . .

RUN ls


ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]