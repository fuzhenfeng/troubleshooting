FROM openjdk:8-jdk-alpine
LABEL maintainer=fuzhenfeng
ADD ./build/libs/hello_world-1.0-SNAPSHOT.jar /hello_world-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","hello_world-1.0-SNAPSHOT.jar"]
EXPOSE 8080