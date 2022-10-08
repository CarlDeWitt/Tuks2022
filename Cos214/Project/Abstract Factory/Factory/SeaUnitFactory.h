#pragma once

#include "UnitFactory.h"

class SeaUnitFactory : public UnitFactory
{
private:
public:
    SeaUnitFactory();
    Unit *createLightUnit();
    Unit *createMediumUnit();
    Unit *createHeavyUnit();
    ~SeaUnitFactory();
};
