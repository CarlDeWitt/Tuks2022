#pragma once

#include "Pokemon.h"
#include <string>
#include "Battlestate.h"
#include "PlayStyle.h"
#include "AgileBattleState.h"
#include "NormalBattleState.h"
#include "StrongBattleState.h"
#include "PhysicalAttackPlayStyle.h"
#include "AttackPlayStyle.h"
#include "RunPlayStyle.h"
using namespace std;

class Pokemon

{
private:
    string name;
    int HP;
    int damage;
    bool run;
    BattleState *state;
    PlayStyle *style;

public:
    Pokemon(string, int, int, PlayStyle *);
    void selectBattleState(string);
    int attack();
    void setStyle(string);
    void takeDamage(int);
    ~Pokemon();
};
