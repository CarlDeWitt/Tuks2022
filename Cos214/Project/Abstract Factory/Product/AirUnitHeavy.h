#pragma once

#include "AirUnit.h"

class AirUnitHeavy : public AirUnit
{
private:
    int HP = 100;
    int damage = 20;

public:
    AirUnitHeavy();
    ~AirUnitHeavy();
};
