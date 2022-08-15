#ifndef SUBTRACT_H
#define SUBTRACT_H
#include "Calculator.h"
class Calculator;

using namespace std;
#include <iostream>

class Subtract : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Subtract();
};

#endif