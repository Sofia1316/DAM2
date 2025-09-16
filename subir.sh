#!/bin/bash

echo "Nombre del commit:"
read Commit # Se encarga de leer el commit

git add .

git commit -m "$Commit"

git push

echo " "
echo "Se acaba de subir al repositorio :)"
