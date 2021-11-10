FROM openjdk:11-jre-slim-sid

COPY target/catalogservice-latest.jar catalogservice.jar
COPY src/main/resources/secure-connect.zip secure-connect.zip
EXPOSE 80

CMD java -jar catalogservice.jar