#pragma once

#include "UnitFactory.h"

class LandUnitFactory : public UnitFactory
{
private:
public:
    LandUnitFactory();
    Unit *createLightUnit();
    Unit *createMediumUnit();
    Unit *createHeavyUnit();
    ~LandUnitFactory();
};
