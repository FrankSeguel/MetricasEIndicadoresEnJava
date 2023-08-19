#!/bin/bash

imagenTag="msppt/metricas"
containerName="ms_ppt_metricas"

portLocal="8080"
portDocker="8080"

echo "Ejecutando Imagen Docker de $imagenTag"

echo "-> Bajando containers"
for cnt in $(docker container ls | grep "${imagenTag} " | awk '{ print $1 }'); do
  echo "->   Container:${cnt}"
  echo "->     docker stop ${cnt}"
  docker stop ${cnt}
done

echo "-> Ejecutando Imagen"

docker run --name ${containerName} -it --restart unless-stopped -d -p ${portLocal}:${portDocker} -p 9090:9090 ${imagenTag}

echo '==FIN del RUN=='
