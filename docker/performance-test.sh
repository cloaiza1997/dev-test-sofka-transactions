#!/bin/bash

counter = 1;

for i in {1..10000}
do
  curl -X 'POST' \
    'http://localhost:8080/v1/transactions' \
    -H 'accept: application/json' \
    -H 'Content-Type: application/json' \
    -d '{
    "transaction": {
      "transactionId": 123,
      "timestamp": "2024-07-03 12:34:56.789",
      "deviceNumber": "456",
      "userId": 789,
      "geoPosition": {
        "latitude": 3.451647,
        "longitude": -76.531982
      },
      "amount": 987.65
    }
  }' &

  echo $counter
  $counter += 1
done