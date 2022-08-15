#include <iostream>
#include "SweetAbstractFactoryUpdated.h"

using namespace std;

int Chocolate::total_ = 0;

Chocolate::Chocolate() {
	id_ = total_++;
}

void Chocolate::wrap() {
  print();
  cout << " " << id_ << ":wrap" << endl;
}

void Chocolate::print() {
  cout<<"Please implement this function in subclasses"<<endl;
}

void Barone::print() { 
	cout << "Barone" ; 
}

void Tex::print() { 
	cout << "Tex" ; 
}


int HardSweet::total_ = 0;

HardSweet::HardSweet() {
	id_ = total_++;
}

void HardSweet::wrap() {
  print();
  cout << " " << id_ << ":wrap" << endl;
}

void HardSweet::print() {
  cout<<"Please implement this function in subclasses"<<endl;
}

void FizzPop::print() { 
	cout << "FizzPop" ; 
}

void Sparkle::print() { 
	cout << "Sparkle" ; 
}


Chocolate* BaroneSparkleFactory::produceChocolate() {
	return new Barone;
}
HardSweet* BaroneSparkleFactory::produceSweet() {
	return new Sparkle;
}

Chocolate* TexFizzPopFactory::produceChocolate()   {
	return new Tex;
}
    
HardSweet* TexFizzPopFactory::produceSweet() {
		return new FizzPop;
}
