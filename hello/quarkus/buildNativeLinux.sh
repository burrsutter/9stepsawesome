#!/bin/bash

export GRAALVM_HOME=~/tools/graalvm-ce-19.1.1/Contents/Home/

mvn package -Pnative -Dnative-image.docker-build=true -DskipTests