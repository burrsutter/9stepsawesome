Initial pom.xml created by start.spring.io

mvn clean compile package

java -jar target/boot-demo-1.0.0.jar
or
mvn spring-boot:run
curl http://localhost:8080/
ctrl-c

Manual Deployment

export IMAGE_VER=boot-demo:1.0.0

docker build -f Dockerfile -t dev.local/burrsutter/$IMAGE_VER .
docker login docker.io
docker tag dev.local/burrsutter/$IMAGE_VER docker.io/burrsutter/$IMAGE_VER
docker push docker.io/burrsutter/$IMAGE_VER

or

docker build -f Dockerfile -t dev.local/burrsutter/$IMAGE_VER .
docker login quay.io
docker tag dev.local/burrsutter/$IMAGE_VER quay.io/burrsutter/$IMAGE_VER
docker push quay.io/burrsutter/$IMAGE_VER

or 
docker build -f Dockerfile.openshift -t dev.local/burrsutter/$IMAGE_VER .
