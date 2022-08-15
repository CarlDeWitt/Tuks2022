#ifndef CALCULATOR_H
#define CALCULATOR_H
#include "Add.h"
#include "Subtract.h"
#include "Multiply.h"

class Calculator {
public:
    virtual int execute(int a, int b) = 0;
    virtual ~Calculator();
};
#endif

