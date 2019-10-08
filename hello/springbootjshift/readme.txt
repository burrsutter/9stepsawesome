This example builds a linux container image, without a Dockerfile, via jib

https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#example

eval $(minikube --profile 9steps docker-env)

mvn clean k8s:resource -Pkubernetes

target/classes/META-INFO/jshift

mvn package k8s:build -Pkubernetes

mvn k8s:deploy -Pkubernetes

IP=$(minikube -p 9steps ip)
NODEPORT=$(kubectl get service/boot-demo -o jsonpath="{.spec.ports[*].nodePort}")

curl $IP:$NODEPORT

Clean up

mvn k8s:undeploy -Pkubernetes