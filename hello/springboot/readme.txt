Intial pom.xml created by start.spring.io

mvn clean compile package

java -jar target/boot-demo-0.0.1.jar
or
mvn spring-boot:run
curl http://localhost:8080/
ctrl-c

Manual Deployment

docker build -f Dockerfile -t dev.local/burrsutter/boot-demo:0.0.1 .
or 
docker build -f Dockerfile.openshift -t dev.local/burrsutter/boot-demo:0.0.1 .

docker login docker.io
docker images | grep boot-demo
docker tag $1 docker.io/burrsutter/boot-demo:0.0.1
docker push docker.io/burrsutter/boot-demo:0.0.1
or
docker login quay.io
docker images | grep boot-demo
docker tag $1 quay.io/burrsutter/boot-demo:0.0.1
docker push quay.io/burrsutter/boot-demo:0.0.1




http://jshift.io/
