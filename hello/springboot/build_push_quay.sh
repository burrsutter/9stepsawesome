#!/bin/bash

docker build -f Dockerfile -t dev.local/burrsutter/$IMAGE_VER .
docker login quay.io
docker tag dev.local/burrsutter/$IMAGE_VER quay.io/burrsutter/$IMAGE_VER
docker push quay.io/burrsutter/$IMAGE_VER
