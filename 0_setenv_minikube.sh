#!/bin/bash

echo 'source 0_setenv.sh'

export MINIKUBE_HOME=/Users/burrsutter/minikube_1.3.1/;
export PATH=$MINIKUBE_HOME/bin:$PATH
# export KUBECONFIG=$MINIKUBE_HOME/.kube/config:$MINIKUBE_HOME/.kube/kubconfig2
export KUBECONFIG=$MINIKUBE_HOME/.kube/config
export KUBE_EDITOR="code -w"

echo 'the following after minikube as started'
echo 'eval $(minikube --profile 9steps docker-env)'
