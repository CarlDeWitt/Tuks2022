#ifndef CONTEXT_H
#define CONTEXT_H

#include "Calculator.h"

class Context {
    
public:
    Context(Calculator* strategy);
    ~Context();
    int calculate(int a, int b);
    
private:
    Calculator* strategy;
};

#endif

