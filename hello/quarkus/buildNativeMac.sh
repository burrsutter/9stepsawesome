#!/bin/bash

export GRAALVM_HOME=~/tools/graalvm-ce-1.0.0-rc12/Contents/Home/

# Mac Native
mvn package -Pnative

# Linux Native
# mvn package -Pnative -Dnative-image.docker-build=true