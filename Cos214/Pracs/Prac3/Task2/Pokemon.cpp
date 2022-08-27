#include "Pokemon.h"
Pokemon::Pokemon(string n, int hp, int d, PlayStyle *s)
{
    name = n;
    HP = hp;
    damage = d;
    style = s;
    state = new NormalBattleState();
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

int Pokemon::attack()
{
    if (this->HP <= 0)
    {
        cout << "Pokemon has fainted" << endl;
        return 0;
    }
    if (run)
    {
        cout << style->attack() << endl;
        return 0;
    }

    int damagedeal = state->handle(name, damage);
    cout << style->attack() << endl;
    return damagedeal;
}
void Pokemon::setStyle(string s)
{
    // style->attack();
    if (s == "r")
    {
        style = new RunPlayStyle();
        run = true;
    }
    else if (s == "p")
    {
        style = new PhysicalAttackPlayStyle();
        run = false;
    }
    else if (s == "s")
    {
        style = new AttackPlayStyle();
        run = false;
    }
}
void Pokemon::takeDamage(int d)
{
    HP -= d;
    HP <= 0 ? cout << "Pokemon has fainted" << endl : cout << "Pokemon has " << HP << " HP left" << endl;
}
Pokemon::~Pokemon() {}
