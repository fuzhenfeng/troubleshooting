echo $(date "+%Y-%m-%d %H:%M:%S")
gradle clean
gradle build
gradle test
docker build -t cpu_load:latest -f Dockerfile .
docker tag cpu_load:latest fuzhenfeng/cpu_load:latest
docker push fuzhenfeng/cpu_load:latest
echo $(date "+%Y-%m-%d %H:%M:%S")
# docker run --name cpu_load -p 8081:8081 8082:8082 fuzhenfeng/cpu_load:latest