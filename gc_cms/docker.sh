echo $(date "+%Y-%m-%d %H:%M:%S")
gradle clean
gradle build
gradle test
docker build -t gc_cms:latest --build-arg JMX_HOST=192.168.1.102 --build-arg JMX_PORT=8083 -f Dockerfile .
docker tag gc_cms:latest fuzhenfeng/gc_cms:latest
docker push fuzhenfeng/gc_cms:latest
echo $(date "+%Y-%m-%d %H:%M:%S")
# docker run --name gc_cms -p 8081:8081 -p 8082:8082 fuzhenfeng/gc_cms:latest