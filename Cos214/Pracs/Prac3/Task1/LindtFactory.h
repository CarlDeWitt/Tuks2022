#pragma once
#include "ConfectioneryFactory.h"
#include "Lindt.h"

class LindtFactory : public ConfectioneryFactory
{    
public:
    LindtFactory();
    Confectionery* createChocolate(bool);
    Confectionery* createAeratedChocolate(int);
    // ~LindtFactory();
};