#pragma once

#include "Pokemon.h"
#include <string>
#include "Battlestate.h"
#include "AgileBattleState.h"
#include "NormalBattleState.h"
#include "StrongBattleState.h"
using namespace std;

class Pokemon

{
private:
    string name;
    int HP;
    int damage;
    BattleState *state;

public:
    Pokemon(string, int, int);
    void selectBattleState(string);
    ~Pokemon();
};
