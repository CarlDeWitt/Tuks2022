#ifndef SUBTRACT_H
#define SUBTRACT_H

using namespace std;
#include <iostream>

#include "Calculator.h"
class Calculator;
class Subtract : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Subtract();
};

#endif