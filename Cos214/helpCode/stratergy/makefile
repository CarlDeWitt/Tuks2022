main:	
	g++ -c -std=c++17 Calculator.cpp
	g++ -c -std=c++17 Context.cpp                 
	g++ -c -std=c++17 StrategyMaths.cpp
	g++ -c -std=c++17 Add.cpp
	g++ -c -std=c++17 Subtract.cpp
	g++ -c -std=c++17 Multiply.cpp
# g++ -c -std=c++11 Main.cpp      	         
	g++ -o main Calculator.o Context.o Add.o Subtract.o Multiply.o
	./main
clean:
	rm *.o main