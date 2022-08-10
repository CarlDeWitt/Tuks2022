#include "SquadMember.h"

SquadMember::SquadMember(string name, int hp, bool alive, int damage)
{
    this->name = name;
    this->HP = hp;
    this->alive = alive;
    this->damage = damage;
    // mt = new Memento();
}

SquadMember::SquadMember()
{
}
bool SquadMember::isAlive()
{
    return this->alive;
}
int SquadMember::getHP()
{
    return this->HP;
}
void SquadMember::die()
{
    cout << "squad died" << endl;
}
string SquadMember::getName()
{
    return this->name;
}

int SquadMember::takeDamage(int damage)
{
    HP = HP - damage;
    return HP;
}

int SquadMember::getDamage()
{
    return damage;
}

void SquadMember::setHP(int hp)
{
    this->HP = hp;
}
void SquadMember::setDamage(int dam)
{
    this->damage = dam;
}

SquadMember SquadMember::Clone()
{
    SquadMember *s = new SquadMember();
    s->name = this->name;
    s->damage = this->damage;
    s->alive = this->alive;
    s->HP = this->HP;

    return *s;
}

void SquadMember::savestate()
{
    SquadMember ns = Clone();
    Memento *mt = new Memento();
    mt->setState(&ns);
}