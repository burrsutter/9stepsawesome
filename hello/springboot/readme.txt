Initial pom.xml created by start.spring.io

mvn clean compile package

java -jar target/boot-demo-1.0.0.jar
or
mvn spring-boot:run
curl http://localhost:8080/
ctrl-c

Manual Deployment

docker build -f Dockerfile -t dev.local/burrsutter/boot-demo:1.0.0 .
or 
docker build -f Dockerfile.openshift -t dev.local/burrsutter/boot-demo:1.0.0 .

docker login docker.io
docker images | grep boot-demo

docker tag $1 docker.io/burrsutter/boot-demo:1.0.0
docker push docker.io/burrsutter/boot-demo:1.0.0

or

docker login quay.io
docker images | grep boot-demo

docker tag $1 quay.io/burrsutter/boot-demo:1.0.0
docker push quay.io/burrsutter/boot-demo:1.0.0
