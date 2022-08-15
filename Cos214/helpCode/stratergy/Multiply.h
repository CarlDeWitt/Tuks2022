#ifndef MULTIPLY_H
#define MULTIPLY_H
#include "Calculator.h"
// class Calculator;
using namespace std;
#include <iostream>

class Multiply : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Multiply();
};

#endif