#pragma once
#include "Basket.h"
#include "string"

using namespace std;

class Checkout

{
private:
    Basket *box;

public:
    Checkout(Basket *);
    void displayItmes();
    // ~Checkout();
};
