#ifndef ADD_CPP
#define ADD_CPP
#include "Add.h"
int Add::execute(int a, int b) {
    cout << "Called Add's execute()" << endl;
    return a + b;  // Do an addition with a and b
}

Add::~Add() {
    cout << " Add deleting" << endl;
}
#endif