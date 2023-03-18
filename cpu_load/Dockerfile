FROM openjdk:11
LABEL maintainer=fuzhenfeng
ADD ./build/libs/cpu_load-1.0-SNAPSHOT.jar /cpu_load-1.0-SNAPSHOT.jar
ENTRYPOINT ["/bin/sh", "-c", "java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8082 -jar /cpu_load-1.0-SNAPSHOT.jar"]
EXPOSE 8081 8082