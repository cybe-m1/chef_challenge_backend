FROM openjdk:11-jdk-oraclelinux7

COPY . ./service

RUN cd service && ./mvnw clean install && ./mvnw package && cd ..

RUN cp service/target/*.jar app.jar

# RUN rm -fr service

CMD ["java", "-jar", "/app.jar"]