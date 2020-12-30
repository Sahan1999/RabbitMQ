FROM openjdk:11
ADD target/rabbitmq-receive-service.jar rabbitmq-receive-service.jar 
EXPOSE 9090
ENTRYPOINT ["java","-jar","rabbitmq-receive-service.jar"]