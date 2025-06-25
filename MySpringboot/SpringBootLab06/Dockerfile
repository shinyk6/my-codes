FROM openjdk:21
VOLUME /tmp
ARG JAR_FILE=target/springlab06-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]