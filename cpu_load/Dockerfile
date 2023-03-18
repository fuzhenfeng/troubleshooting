FROM openjdk:11
LABEL maintainer=fuzhenfeng
ADD ./build/libs/cpu_load-1.0-SNAPSHOT.jar /cpu_load-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cpu_load-1.0-SNAPSHOT.jar"]
EXPOSE 8081