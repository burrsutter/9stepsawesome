#!/bin/bash

while true
do 
  curl $(minikube -p 9steps ip):$(kubectl get service/myboot -o jsonpath="{.spec.ports[*].nodePort}" -n myspace)
  sleep .2;
done

