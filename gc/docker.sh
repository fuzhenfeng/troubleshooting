echo $(date "+%Y-%m-%d %H:%M:%S")
gradle clean
gradle build
gradle test
docker build -t gc:latest -f Dockerfile .
docker tag gc:latest fuzhenfeng/gc:latest
docker push fuzhenfeng/gc:latest
echo $(date "+%Y-%m-%d %H:%M:%S")
# docker run --name gc -p 8081:8081 8082:8082 fuzhenfeng/gc:latest