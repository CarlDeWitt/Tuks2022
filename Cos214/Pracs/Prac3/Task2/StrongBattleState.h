
#pragma once

#include "BattleState.h"

class StrongBattleState : public BattleState

{
private:
public:
    StrongBattleState();
    int handle(string, int);
    ~StrongBattleState();
};
