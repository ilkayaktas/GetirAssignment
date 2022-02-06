#!/bin/bash

export MYSQL_IP=localhost

./gradlew build -x test

containerId=$(docker stop ilkayaktas/readingisgood-getir)

# Remove container
docker rm $containerId

# Remove image
docker rmi ilkayaktas/readingisgood-getir

# Build image
docker build --build-arg JAR_FILE=build/libs/\*.jar -t ilkayaktas/readingisgood-getir .
