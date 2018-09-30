#!/bin/bash

while true
do 
  curl $(minishift ip):$(kubectl get service/myboot -o jsonpath="{.spec.ports[*].nodePort}" -n myspace)
  sleep .5;
done

