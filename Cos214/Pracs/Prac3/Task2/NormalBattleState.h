#pragma once

#include "BattleState.h"

class NormalBattleState : public BattleState

{
private:
public:
    NormalBattleState();
    int handle(string, int);
    ~NormalBattleState();
};
