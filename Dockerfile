FROM openjdk8
WORKDIR app
COPY ./target/*.jar /app/customers.jar
ENTRYPOINT java -jar customers.jar