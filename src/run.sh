find ./ -name "*.java" > sources.txt           
javac -sourcepath ./ @sources.txt                  
java ua/avaj/simulator/Main  $1
