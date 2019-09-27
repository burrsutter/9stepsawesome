#!/bin/bash

export GRAALVM_HOME=~/tools/graalvm-ce-19.1.1/Contents/Home/

# Mac Native
mvn package -Pnative

