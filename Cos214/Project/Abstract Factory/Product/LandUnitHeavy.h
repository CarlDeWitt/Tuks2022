#pragma once

#include "LandUnit.h"

class LandUnitHeavy : public LandUnit
{
private:
    int HP = 100;
    int damage = 20;

public:
    LandUnitHeavy();
    ~LandUnitHeavy();
};