FROM openjdk:8
COPY target/registration-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]