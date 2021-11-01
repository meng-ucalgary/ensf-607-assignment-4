@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath src -d bin src/Task_2/*java

@REM RUN
java -cp bin Task_2.Driver

@REM DON'T SUDDENLY QUIT
PAUSE
