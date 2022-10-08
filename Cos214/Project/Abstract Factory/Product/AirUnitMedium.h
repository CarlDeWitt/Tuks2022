#pragma once

#include "AirUnit.h"

class AirUnitMedium : public AirUnit
{
private:
    int HP = 75;
    int damage = 10;

public:
    AirUnitMedium();
    ~AirUnitMedium();
};
