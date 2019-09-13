#!/bin/bash

minikube --profile 9steps config set memory 6144
minikube --profile 9steps config set cpus 2 
minikube --profile 9steps config set vm-driver virtualbox #hyperkit 
# kubernetes version only applies to minikube
minikube --profile 9steps config set kubernetes-version v1.14.0 
# minishift addon enable admin-user 
# minishift addon enable anyuid 
minikube start --profile 9steps