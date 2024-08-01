# rabbitmq.sh
#!/bin/bash

# Docker compose
echo "*** docker-compose init ***"

docker-compose up -d --build

echo "*** docker-compose end ***"

# RabbitMQ
echo "*** rabbitmq init enable pluggin ***"

docker exec rabbitmq rabbitmq-plugins enable rabbitmq_amqp1_0

echo "*** rabbitmq restart ***"

docker stop rabbitmq

docker start rabbitmq

echo "*** rabbitmq is ready to use ***"