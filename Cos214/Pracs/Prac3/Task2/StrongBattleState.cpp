#include "StrongBattleState.h"
StrongBattleState::StrongBattleState() : BattleState()
{
    battlestate = "Strong";
}
int StrongBattleState::handle(string name, int damage)
{
    damage = damage * 2;
    cout << name << "has selected a strong battle state, and will inflict " << damage << " points on the next battle attack but misses the following attack turn." << endl;
    return damage;
}
StrongBattleState::~StrongBattleState() {}
