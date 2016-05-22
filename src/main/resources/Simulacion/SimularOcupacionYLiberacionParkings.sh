#!/bin/bash
CT="Content-Type:application/json"


while :
do

opcion=$(($RANDOM%1))
id=$(($RANDOM % 17) + 1)

if [ "$opcion" = 0 ]
then
    echo "Ocupando plaza de un parking aleatoriamente."
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT http://localhost:8080/parking/$id/ocuparPlaza
else
    echo "Liberando plaza de un parking aleatoriamente."
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT http://localhost:8080/parking/$id/liberarPlaza
fi

sleep 0.1
done