#!/bin/bash

echo 'source 0_setenv.sh'

export MINIKUBE_HOME=/Users/burrsutter/minikube_1.0.0/;
export PATH=$MINIKUBE_HOME/bin:$PATH
# export KUBECONFIG=$MINIKUBE_HOME/.kube/config:$MINIKUBE_HOME/.kube/kubconfig2
export KUBECONFIG=$MINIKUBE_HOME/.kube/config
export KUBE_EDITOR="code -w"

echo 'the following after minikube as started'
echo 'eval $(minikube --profile 9steps docker-env)'
echo 
echo 'Trying Kui https://github.com/IBM/kui'
echo 'curl -sL https://tarball.kui-shell.org | tar jxf -'
export PATH=$MINIKUBE_HOME/kui/bin:$PATH
echo 'kui shell'
echo 'or'
echo 'kubectl kui get pods --ui'