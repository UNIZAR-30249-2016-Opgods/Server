#!/bin/bash
CT="Content-Type:application/json"


while :
do
	id=$(($RANDOM % 75))
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT http://localhost:8080/profesores/cambiarDisponibilidad/$id
	echo "Modificando la disponibilidad de un profesor aleatorio."
	sleep 3
done