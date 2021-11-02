@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath src -d bin src/Task_3/*java

@REM RUN
java -cp bin Task_3.Driver

@REM DON'T SUDDENLY QUIT
PAUSE
