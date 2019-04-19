#!/bin/bash

kubectl patch -n kube-system service/kubernetes-dashboard -p '{"spec":{"type":"NodePort"}}' 

open http://$(minikube -p 9steps ip):$(kubectl get svc kubernetes-dashboard -n kube-system -o 'jsonpath={.spec.ports[0].nodePort}')