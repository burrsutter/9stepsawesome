#!/bin/bash

minishift --profile 9stepsMS2 config set memory 6144
minishift --profile 9stepsMS2 config set cpus 2 
minishift --profile 9stepsMS2 config set vm-driver virtualbox #hyperkit 
# kubernetes version only applies to minikube
# minikube --profile 9steps config set kubernetes-version v1.14.0 
minishift --profile 9stepsMS2 addon enable admin-user 
minishift --profile 9stepsMS2 addon enable anyuid 
minishift start --profile 9stepsMS2 --vm-driver virtualbox --memory 6144 --cpus 2 --addon enable=admin-user --addon enable=anyuid

# oc adm policy add-cluster-role-to-user cluster-admin admin