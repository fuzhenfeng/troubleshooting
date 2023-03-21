FROM openjdk:8-jdk-alpine
LABEL maintainer=fuzhenfeng
ENV TZ=Asia/Shanghai
RUN apk update \
    && apk add tzdata \
    && echo "${TZ}" > /etc/timezone \
    && ln -sf /usr/share/zoneinfo/${TZ} /etc/localtime \
    && rm /var/cache/apk/*
ARG JMX_HOST=${JMX_HOST}
ARG JMX_PORT=${JMX_PORT}
ENV JAVA_OPTS="\
-Xms256m \
-Xmx256m \
-Xss256k \
-Xmn128m \
-XX:SurvivorRatio=8 \
-XX:NewRatio=4 \
-XX:+UseParNewGC \
-XX:+UseConcMarkSweepGC \
-Xloggc:./gc-%t.log \
-verbosegc \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-XX:+PrintGCCause \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./jvm.dump \
-Djava.rmi.server.hostname=$JMX_HOST \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.rmi.port=$JMX_PORT \
-Dcom.sun.management.jmxremote.port=$JMX_PORT \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8082 \
"
ADD ./build/libs/gc_cms-1.0-SNAPSHOT.jar /gc_cms-1.0-SNAPSHOT.jar
ENTRYPOINT ["/bin/sh", "-c", "java ${JAVA_OPTS} -jar /gc_cms-1.0-SNAPSHOT.jar"]
EXPOSE 8081 8082 8083


