#pragma once

#include "string"
#include <iostream>
using namespace std;
class Basket

{
public:
    Basket();
    virtual void addItem(Basket *chockName) = 0;
    virtual void removeItem() = 0;
    virtual void chockInfo() = 0;
    // ~Basket();
};
