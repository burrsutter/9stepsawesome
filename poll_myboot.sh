#!/bin/bash

while true
do 
  curl $(minikube ip):$(kubectl get service/myboot -o jsonpath="{.spec.ports[*].nodePort}" -n myspace)
  sleep .5;
done

