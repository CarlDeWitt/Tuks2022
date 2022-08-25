#include "AgileBattleState.h"
AgileBattleState::AgileBattleState() : BattleState()
{
    battlestate = "Agile";
}
int AgileBattleState::handle(string name, int damage)
{
    damage = damage * 0.75;
    cout << name << "has selected an agile battle state, and is allowed two battle attacks in one turn and will deal" << damage << " points." << endl;
    return damage;
}
AgileBattleState::~AgileBattleState() {}
