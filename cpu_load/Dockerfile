FROM openjdk:8-jdk-alpine
LABEL maintainer=fuzhenfeng
ADD ./build/libs/cup_load-1.0-SNAPSHOT.jar /cup_load-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cup_load-1.0-SNAPSHOT.jar"]
EXPOSE 8080