FROM openjdk:11
LABEL maintainer=fuzhenfeng
ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="\
-Xms1024m \
-Xmx1024m \
-Xss256k \
-Xmn512m \
-XX:SurvivorRatio=8 \
-XX:NewRatio=4 \
-XX:+UseG1GC \
-Xloggc:./gc-%t.log \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-XX:+PrintGCCause \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./jvm.dump \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8082 \
"
ADD ./build/libs/gc-1.0-SNAPSHOT.jar /gc-1.0-SNAPSHOT.jar
ENTRYPOINT ["/bin/sh", "-c", "java ${JAVA_OPTS} -jar /gc-1.0-SNAPSHOT.jar"]
EXPOSE 8081 8082