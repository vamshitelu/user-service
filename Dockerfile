FROM openjdk:8
EXPOSE 8090
ADD target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar","user-service" ]