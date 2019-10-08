#!/bin/bash

kubectl -n mystuff delete configmap pizza-controller

kubectl -n mystuff delete -f webhook-py.yaml

kubectl -n mystuff delete -f pizza-controller.yaml