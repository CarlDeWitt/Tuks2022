#include <iostream>

#include "Context.h"

using namespace std;


Context::Context(Calculator* strategy) {
    this->strategy = strategy;
}
    
int Context::calculate(int a, int b) {
    return strategy->execute(a, b);
}

Context::~Context() {
    cout << "Deleting strategy" << endl;
    delete strategy;
    strategy = 0;
}

