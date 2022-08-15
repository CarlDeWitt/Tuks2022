#include "Multiply.h"
int Multiply::execute(int a, int b) {
    cout << "Called Multiply's execute()" << endl;
    return a * b;   // Do a multiplication with a and b
}

Multiply::~Multiply() {
    cout << " Add deleting" << endl;
}