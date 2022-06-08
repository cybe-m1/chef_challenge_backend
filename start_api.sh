#!/bin/bash

set -e
trap cleanup 0 1 2 3 6 15
cleanup() {
    pgrep -P $$ | xargs kill
    exit 1
}

if [ "$1" = "--install" ]
then

  for SERVICE in eureka admin gateway challenges ingredients recipes stock users
  do
    cd $SERVICE && ./mvnw package && cd ..
  done
fi

java -jar eureka/target/*.jar &
java -jar admin/target/*.jar &
java -jar gateway/target/*.jar &
java -jar ingredients/target/*.jar &
java -jar recipes/target/*.jar &
java -jar stock/target/*.jar &
java -jar challenges/target/*.jar &
java -jar users/target/*.jar