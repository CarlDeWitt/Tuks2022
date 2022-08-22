#pragma once
#include "Choclate.h"
#include "AeratedChocolate.h"
#include "Confectionery.h"
class ConfectioneryFactory
{
    public:
        ConfectioneryFactory();
        virtual Confectionery* createChocolate(bool) = 0;
        virtual Confectionery* createAeratedChocolate(int) = 0;
        // virtual ~ConfectioneryFactory();
};