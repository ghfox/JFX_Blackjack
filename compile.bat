javac .\src\blackjack\*.java -d .\build 
@ECHO DONE COMPILING!
@ECHO TRY TO JAR
set CLASSPATH=.build\blackjack
cd build
jar cmf manifest.txt Blackjack.jar blackjack\*.class
@ECHO JARRED
PAUSE