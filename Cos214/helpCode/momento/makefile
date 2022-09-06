example: State.o ProductBackup.o ProductStateMemory.o Product.o MementoExample.cpp
	g++ State.o ProductBackup.o ProductStateMemory.o Product.o MementoExample.cpp  -o example
	
ProductBackup.o: ProductBackup.cpp ProductBackup.h State.h
	g++ -c ProductBackup.cpp
	
Product.o: Product.cpp Product.h State.h ProductBackup.h
	g++ -c Product.cpp
	
ProductStateMemory.o: ProductStateMemory.cpp ProductStateMemory.h \
  ProductBackup.h State.h
	g++ -c ProductStateMemory.cpp
	
State.o: State.cpp State.h
	g++ -c State.cpp
	