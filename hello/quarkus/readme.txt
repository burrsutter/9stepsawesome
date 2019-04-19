
mvn compile quarkus:dev
curl localhost:8080
ctrl-c 

mvn clean package

./buildNativeLinux.sh

./dockerbuild.sh


kubectl apply -f kubefiles/Deployment.yml
OR
kubectl apply -f kubefiles/Deployment_quay.yml

kubectl apply -f kubefiles/Service.yml

./poller.sh


