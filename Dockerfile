FROM openjdk:11-jdk-oraclelinux7

COPY . ./app

RUN cd app

RUN for i in eureka gateway users admin; do cd $i && ./mvnw clean install && cp target/*.jar ../$i.jar && cd .. && rm -fr $i; done

RUN ls