#!/bin/bash

while true
do 
  curl $(minikube ip):$(kubectl get service/mynode -o jsonpath="{.spec.ports[*].nodePort}" -n yourspace)
  sleep .5;
done

