#pragma once

#include "SeaUnit.h"

class SeaUnitLight : public SeaUnit
{
private:
    int HP = 50;
    int damage = 5;

public:
    SeaUnitLight();
    ~SeaUnitLight();
};
