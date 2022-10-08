#pragma once

#include "LandUnit.h"

class LandUnitMedium : public LandUnit
{
private:
    int HP = 75;
    int damage = 10;

public:
    LandUnitMedium();
    ~LandUnitMedium();
};