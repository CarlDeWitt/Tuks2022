#include "Pokemon.h"
Pokemon::Pokemon(string n, int hp, int d)
{
    name = n;
    HP = hp;
    damage = d;
}
void Pokemon::selectBattleState(string s)
{
    if (s == "agile")
    {
        state = new AgileBattleState();
    }
    else if (s == "normal")
    {
        state = new NormalBattleState();
    }
    else if (s == "strong")
    {
        state = new StrongBattleState();
    }
    state->handle(name, damage);
}
Pokemon::~Pokemon() {}
