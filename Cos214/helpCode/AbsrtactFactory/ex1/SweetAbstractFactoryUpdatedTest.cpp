#include <iostream>
#include "SweetAbstractFactoryUpdated.h"

using namespace std;

int main() {
  Factory** factory  = new Factory*[2];
  factory[0] = new BaroneSparkleFactory;
  factory[1] = new TexFizzPopFactory;
	
  Sweet*  sweets[4];
	
  sweets[0] = factory[0]->produceChocolate();
  sweets[1] = factory[1]->produceChocolate();
  sweets[2] = factory[0]->produceSweet();
  sweets[3] = factory[1]->produceSweet();
	
  for (int i=0; i < 4; i++) {
    sweets[i]->wrap();
  }

	
  for (int i=0; i < 4; i++) {
    delete sweets[i];
  }
	
  for (int i=0; i < 2; i++) {
    delete factory[i];
  }
  delete [] factory;
	
  return 0;
	
}
