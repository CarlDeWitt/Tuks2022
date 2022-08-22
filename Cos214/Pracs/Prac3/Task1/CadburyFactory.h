#pragma once
#include "ConfectioneryFactory.h"
#include "DiaryMilk.h"
#include "DiaryMilkBubbly.h"

class CadburyFactory : public ConfectioneryFactory
{ 
public:
    CadburyFactory();
    Confectionery* createChocolate(bool);
    Confectionery* createAeratedChocolate(int);
    ~CadburyFactory();
};

