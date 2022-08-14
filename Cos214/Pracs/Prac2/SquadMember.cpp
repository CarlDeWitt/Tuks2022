#include "SquadMember.h"
#include "Memento.h"

Memento *mt = new Memento();

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
    cout << "squadMember died" << endl;
}
string SquadMember::getName()
{
    return this->name;
}

int SquadMember::takeDamage(int damage)
{
    HP = HP - damage;
    cout << "HP is: " << HP << endl;
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

SquadMember *SquadMember::Clone()
{
    SquadMember *s = new SquadMember();
    s->name = this->name;
    s->damage = this->damage;
    s->alive = this->alive;
    s->HP = this->HP;
    return s;
}

void SquadMember::savestate()
{
    SquadMember *ns = Clone();
    mt->setMementoState(ns);
}

SquadMember *SquadMember::restorestate()
{
    SquadMember *ns = mt->getState();
    cout <<"HP is restored to: " << ns->getHP() << " from: " << HP << endl << endl;
    this->name = ns->name;
    this->damage = ns->damage;
    this->alive = ns->alive;
    this->HP = ns->HP;
    return ns;
}
SquadMember::~SquadMember()
{
}