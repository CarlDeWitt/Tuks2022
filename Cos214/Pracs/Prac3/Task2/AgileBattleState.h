#pragma once

#include "BattleState.h"

class AgileBattleState : public BattleState

{
private:
public:
    AgileBattleState();
    int handle(string, int);
    ~AgileBattleState();
};
