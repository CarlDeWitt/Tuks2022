#pragma once

#include "UnitFactory.h"

class AirUnitFactory : public UnitFactory
{
private:
public:
    AirUnitFactory(string name);
    Unit *createLightUnit();
    Unit *createMediumUnit();
    Unit *createHeavyUnit();
    ~AirUnitFactory();
};
