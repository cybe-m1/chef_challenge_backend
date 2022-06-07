FROM openjdk:11-jdk-oraclelinux7

COPY . ./app

RUN for i in eureka gateway users admin; do cd app/$i && ./mvnw clean install && cp target/*.jar ../$i.jar && cd ../../ && rm -fr app/$i; done

RUN ls