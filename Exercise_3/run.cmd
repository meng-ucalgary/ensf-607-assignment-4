@REM CLEAR THE SCREEN
CLS

@REM COMPILE THE FILES
javac -sourcepath src -d bin src/*java

@REM RUN THE SERVER IN BACKGROUND
START /b java -cp bin Server

@REM RUN THE CLIENT
java -cp bin Client

@REM DON'T SUDDENLY QUIT
PAUSE
