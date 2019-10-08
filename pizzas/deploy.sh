#!/bin/bash

kubectl -n mystuff apply -f pizza-controller.yaml

kubectl -n mystuff create configmap pizza-controller --from-file=sync.py

kubectl -n mystuff apply -f webhook-py.yaml
