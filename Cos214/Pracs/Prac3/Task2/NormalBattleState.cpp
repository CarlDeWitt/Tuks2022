#include "NormalBattleState.h"
NormalBattleState::NormalBattleState() : BattleState()
{
    battlestate = "Normal";
}
int NormalBattleState::handle(string name, int damage)
{
    cout << name << "has no special battle state, normal battle attack will deal " << damage << " points." << endl;
    return damage;
}
NormalBattleState::~NormalBattleState() {}
