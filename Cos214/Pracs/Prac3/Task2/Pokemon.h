#pragma once

#include "Pokemon.h"
#include <string>
using namespace std;

class Pokemon

{
private:
    string name;
    int HP;
    int damage;
    BattleState state;

public:
    Pokemon();
    void selectBattleState();
    ~Pokemon();
};
