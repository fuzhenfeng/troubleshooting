gradle clean
gradle build
gradle test
docker build -t hello_world:0.0.1 -f Dockerfile .
docker tag hello_world:0.0.1 fuzhenfeng/hello_world:0.0.1
docker push fuzhenfeng/hello_world:0.0.1
# docker run --name hello_world -p 8081:8081 fuzhenfeng/hello_world:0.0.1