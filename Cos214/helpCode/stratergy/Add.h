#ifndef ADD_H
#define ADD_H
#include "Calculator.h"
class Calculator;
using namespace std;
#include <iostream>

class Add : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Add();
};

#endif