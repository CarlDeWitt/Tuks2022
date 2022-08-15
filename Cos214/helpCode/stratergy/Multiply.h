#ifndef MULTIPLY_H
#define MULTIPLY_H
using namespace std;
#include <iostream>

#include "Calculator.h"
class Calculator;
class Multiply : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Multiply();
};

#endif