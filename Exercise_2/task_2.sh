#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the files
javac -sourcepath src -d bin src/Task_2/*java

# run
java -cp bin Task_2.Driver
