gradle clean
gradle build
gradle test
docker build -t hello_world:0.0.1 -f Dockerfile .
docker tag cup_load fuzhenfeng/cup_load:0.0.1
docker push fuzhenfeng/cup_load:0.0.1
# docker run --name cup_load -p 8080:8080 fuzhenfeng/cup_load:0.0.1