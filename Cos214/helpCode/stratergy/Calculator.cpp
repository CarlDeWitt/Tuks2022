#include <iostream>

#include "Calculator.h"

using namespace std;

Calculator::~Calculator() { }

int Add::execute(int a, int b) {
    cout << "Called Add's execute()" << endl;
    return a + b;  // Do an addition with a and b
}

Add::~Add() {
    cout << " Add deleting" << endl;
}

int Subtract::execute(int a, int b) {
        cout << "Called Subtract's execute()" << endl;
        return a - b;  // Do a subtraction with a and b
}

Subtract::~Subtract() {
    cout << " Subtract deleting" << endl;
}

int Multiply::execute(int a, int b) {
    cout << "Called Multiply's execute()" << endl;
    return a * b;   // Do a multiplication with a and b
}

Multiply::~Multiply() {
    cout << " Add deleting" << endl;
}

