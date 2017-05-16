#!/bin/bash

mvn clean install

echo "Start of 'two-players' application!" 

cd $PWD/target
java -jar two-players-1.0.jar

echo "End of 'two-players' application!"

