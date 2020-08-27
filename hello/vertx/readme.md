# Vert.x Demo
Initial pom.xml created by
mvn io.fabric8:vertx-maven-plugin:1.0.7:setup -DvertxVersion=3.4.2 -Ddependencies=web

Assumes use of CDK Minishift
https://developers.redhat.com/products/cdk/download/

Build project:
```
mvn clean compile package
```
Run your application using:
```
java -jar  target/vertx-demo-1.0-SNAPSHOT.jar
or
mvn vertx:run
```

Access application running locally:
```
http://localhost:8080/hello
ctrl-c
```

## Deploying onto Minishift
```
minishift ip
minishift oc-env

oc login 192.168.99.101:8443
admin
admin
```
(note: the admin user is created by the CDK version of Minishift only)

Create new Project for demo:
```
oc new-project vertxdemo
```

Add Eclipse JKube's OpenShift Maven Plugin to your `pom.xml` in openshift profile. Once added, deploy your application to OpenShift using `oc:deploy` goal:

```
mvn oc:deploy
```

Access the deployed OpenShift route:

http://vertx-demo-vertxdemo.192.168.99.101.nip.io/hello

## Deploying onto Minikube
Make sure you have [minikube](https://github.com/kubernetes/minikube) installed on your system.

Create a new namespace:
``
kubectl create ns swarm-demo`
``

To point your shell to minikube's docker-daemon, run:
```
eval $(minikube -p minikube docker-env)
```
Deploy application to Kubernetes using [Eclipse JKube](https://www.eclipse.org/jkube/):
```
mvn k8s:deploy -Pkubernetes
```

Access your application running in Kubernetes, by default Eclipse JKube generates `Service` of type `ClusterIP`, so you would need to access it by doing `minikube ssh`. However, you can easily customize `Service` type using `jkube.enricher.jkube-service.type` property:
```
vertx : $ kubectl get pods
NAME                          READY   STATUS    RESTARTS   AGE
vertx-demo-cd7d484f5-4md6t    1/1     Running   0          5m54s
vertx : $ kubectl get svc
NAME                    TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
kubernetes              ClusterIP   10.96.0.1        <none>        443/TCP          4d22h
vertx-demo              ClusterIP   10.110.245.220   <none>        8080/TCP         5m57s
vertx : $ minikube ssh
                         _             _            
            _         _ ( )           ( )           
  ___ ___  (_)  ___  (_)| |/')  _   _ | |_      __  
/' _ ` _ `\| |/' _ `\| || , <  ( ) ( )| '_`\  /'__`\
| ( ) ( ) || || ( ) || || |\`\ | (_) || |_) )(  ___/
(_) (_) (_)(_)(_) (_)(_)(_) (_)`\___/'(_,__/'`\____)

$ curl 10.110.245.220:8080/hello
Hello from Vert.x! Thu Aug 27 11:17:19 GMT 2020 on vertx-demo-cd7d484f5-4md6t$ 
```
