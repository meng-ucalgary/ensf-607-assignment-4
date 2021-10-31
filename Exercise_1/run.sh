#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the files
javac -sourcepath src -d bin src/*java

# run
java -cp bin SimpleThread
