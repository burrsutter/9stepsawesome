#!/bin/bash

while true
do 
  curl $(minikube ip):$(kubectl get service/myboot -o jsonpath="{.spec.ports[*].nodePort}")
  sleep .5;
done

