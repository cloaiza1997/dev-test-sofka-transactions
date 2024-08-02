# rabbitmq.sh
#!/bin/bash

# Docker compose
echo "*** docker-compose init ***"

docker-compose -f ./docker/docker-compose.yml up -d --build

echo "*** docker-compose end ***"

# RabbitMQ
echo "*** rabbitmq init enable pluggin ***"

docker exec rabbitmq rabbitmq-plugins enable rabbitmq_amqp1_0

echo "*** rabbitmq restart ***"

docker stop rabbitmq
docker start rabbitmq

echo "*** rabbitmq is ready to use ***"

# Api
echo "*** quarkus init ***"

./mvnw clean
./mvnw install
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/dev-test-sofka-transactions .
docker run -d --name transactions_api -p 8080:8080 quarkus/dev-test-sofka-transactions

echo "*** quarkus end ***"