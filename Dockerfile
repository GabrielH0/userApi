FROM openjdk:17-jdk-alpine3.13
ARG JAR_FILE='target/*.jar'
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]


