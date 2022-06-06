# FROM openjdk:11-jdk-oraclelinux7

# RUN echo "\n\nUpload of eureka service\n\n"

# COPY . ./service

# RUN cd service && ./mvnw clean install && cd ..
# RUN ls service/target

# ARG JAR_FILE=service/target/*.jar
# COPY service/target/*.jar app.jar

# RUN rm -fr service

# ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:11-jdk-oraclelinux7

RUN echo "Upload of gateway service"

COPY ./target/*.jar .

ENTRYPOINT ["java", "-jar", "/app.jar"]