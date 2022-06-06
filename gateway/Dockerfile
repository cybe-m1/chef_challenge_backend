FROM openjdk:11-jdk-oraclelinux7

COPY ./target ./target

# RUN ./mvnw clean install


ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]