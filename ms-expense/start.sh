#!/bin/bash

./mvnw clean
./mvnw package

docker build -t ms-expense .
docker-compose up
