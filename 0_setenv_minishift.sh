#!/bin/bash

echo 'source 0_setenv.sh'

export MINISHIFT_HOME=/Users/burrsutter/minishift_1.33.0/;
export PATH=$MINISHIFT_HOME/bin:$PATH
# export KUBECONFIG=$MINISHIFT_HOME/.kube/config:$MINISHIFT_HOME/.kube/kubconfig2
export KUBECONFIG=$MINISHIFT_HOME/.kube/config
export KUBE_EDITOR="code -w"

echo 'the following after minikube as started'
echo 'eval $(minishift --profile 9steps docker-env)'
