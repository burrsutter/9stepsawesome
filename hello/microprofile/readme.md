# Wildfly Swarm Example

Assumes use of CDK Minishift
https://developers.redhat.com/products/cdk/download/

Build project:
```
mvn clean compile package
```
Run application using these commands:

```
java -jar target/demo-swarm.jar
or
mvn wildfly-swarm:run
```

Access your application:
```
http://localhost:8080/hello
ctrl-c
```

## For Deployment onto Minishift:
```
minishift ip
minishift oc-env
oc login 192.168.99.101:8443
admin
admin
```

(note: the admin user is created by the CDK version of Minishift only)

```
oc new-project swarmdemo
```

Deploy application to OpenShift using [Eclipse JKube](https://www.eclipse.org/jkube/):
```
mvn oc:deploy -Popenshift
```

http://swarm-demo-swarmdemo.192.168.99.101.nip.io/hello

## For Deployment onto Minikube:

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
microprofile : $ kubectl get pods
NAME                          READY   STATUS    RESTARTS   AGE
swarm-demo-55d965bb88-tzbmv   1/1     Running   0          8m44s
microprofile : $ kubectl get svc
NAME                    TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
swarm-demo              ClusterIP   10.103.94.77    <none>        8080/TCP         8m51s
microprofile : $ minikube ssh
                         _             _            
            _         _ ( )           ( )           
  ___ ___  (_)  ___  (_)| |/')  _   _ | |_      __  
/' _ ` _ `\| |/' _ `\| || , <  ( ) ( )| '_`\  /'__`\
| ( ) ( ) || || ( ) || || |\`\ | (_) || |_) )(  ___/
(_) (_) (_)(_)(_) (_)(_)(_) (_)`\___/'(_,__/'`\____)

$ curl 10.103.94.77:8080/hello
Hello from WildFly Swarm! Thu Aug 27 10:28:33 GMT 2020 on swarm-demo-55d965bb88-tzbmv
```
