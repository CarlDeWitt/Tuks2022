#pragma once

#include "SeaUnit.h"

class SeaUnitHeavy : public SeaUnit
{
private:
    int HP = 100;
    int damage = 20;

public:
    SeaUnitHeavy();
    ~SeaUnitHeavy();
};
