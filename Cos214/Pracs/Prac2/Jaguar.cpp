#include "Jaguar.h"

Jaguar::Jaguar(int hp, string attack, int damage, string defensive, string primaryWeapon) : Enemy(hp, attack, damage, defensive, primaryWeapon)
{
}

bool Jaguar::hitSquadMember(SquadMember *z)
{
    cout << "Jaguar " << name << " leaps toward the " << z->getName() << " and deliver's a forceful " << this->primaryWeapon << endl;
    int health = z->takeDamage(damage); // add take damage
    if (health <= 0)
        return true;

    return false;
}
void Jaguar::celebrate()
{
    cout << name << ": Should have fought harder soldier." << endl;
}
bool Jaguar::getHit(SquadMember *z)
{
    if (!z->isAlive())
    {

        return false;
    }
    cout << "Growls in pain as he is maimed. Jaguar turns around and delivers " << this->defensive << "against" << z->getName() << endl;
    HP = HP - z->getDamage(); // add getDamage
    if (HP <= 0)
    {
        return true;
    }
    return false;
}
void Jaguar::die()
{
    cout << "Gives one last growl before falling over" << endl;
}

void Jaguar::setName(string name)
{
    this->name = name;
}
Jaguar::~Jaguar()
{
}