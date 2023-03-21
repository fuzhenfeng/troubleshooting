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
-Xms64m \
-Xmx64m \
-Xss256k \
-Xmn32m \
-XX:SurvivorRatio=8 \
-XX:NewRatio=4 \
-XX:+UseParNewGC \
-XX:+UseConcMarkSweepGC \
-verbosegc \
-Xloggc:./gc-%t.log \
-verbose:class \
-XX:+PrintReferenceGC \
-XX:+TraceClassLoading \
-XX:+TraceClassUnLoading \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-XX:+PrintGCCause \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./tmp \
-Djava.rmi.server.hostname=$JMX_HOST \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.rmi.port=$JMX_PORT \
-Dcom.sun.management.jmxremote.port=$JMX_PORT \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8082 \
"
ADD ./build/libs/gc_cms-1.0-SNAPSHOT.jar /gc_cms-1.0-SNAPSHOT.jar
RUN echo "java ${JAVA_OPTS} -jar /gc_cms-1.0-SNAPSHOT.jar" > /start.sh && chmod 777 /start.sh
ENTRYPOINT ["/bin/sh", "/start.sh"]
EXPOSE 8081 8082 8083


