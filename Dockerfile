FROM openjdk:8-jre
WORKDIR app
COPY ./target/*.jar /app/customers.jar
ENTRYPOINT java -jar customers.jar