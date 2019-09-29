Test it plain
node -v
v8.11.3
npm -v
v8.11.3


npm start
curl localhost:8000

Test it in minishift or minikube's Docker
minishift docker-env
minikube docker-env


docker build -f Dockerfile -t dev.local/burrsutter/mynode:v1 .
or 
docker build -f Dockerfile.openshift -t dev.local/burrsutter/mynode:v1 .

docker login docker.io
docker images | grep mynode
docker tag $1 docker.io/burrsutter/mynode:v1
docker push docker.io/burrsutter/mynode:v1
or
docker login quay.io
docker images | grep mynode
docker tag $1 quay.io/burrsutter/mynode:v1
docker push quay.io/burrsutter/mynode:v1



to test via Docker:
docker run --rm -d -p 8000:8000 dev.local/burrsutter/mynode:v1

docker ps | grep mynode

docker stop 08efa083696b


deploy it into minikube/minishift

kubectl create -f kubefiles/mynode-deployment.yml