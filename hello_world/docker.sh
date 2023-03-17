gradle clean
gradle build
gradle test
docker build -t hello_world:0.0.1 -f Dockerfile .
docker tag hello_world silverdawn/hello_world:0.0.1
docker push silverdawn/hello_world:0.0.1
# docker run --name hello_world -p 8080:8080 hello_world:0.0.1