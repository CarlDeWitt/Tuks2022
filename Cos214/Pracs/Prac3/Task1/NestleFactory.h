#pragma once
#include "ConfectioneryFactory.h"
#include "MilkyBar.h"
#include "Areo.h"

class NestleFactory : public ConfectioneryFactory
{
public:
    NestleFactory();
    Confectionery* createChocolate(bool);
    Confectionery* createAeratedChocolate(int);
    // ~NestleFactory();
};