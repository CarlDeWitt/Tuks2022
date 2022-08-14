#include "Cannibal.h"

Cannibal::Cannibal(int hp, string attack, int damage, string defensive, string primaryWeapon) : Enemy(hp, attack, damage, defensive, primaryWeapon)
{
}

bool Cannibal::hitSquadMember(SquadMember *z)
{
    cout << "Cannibal " << name << " rushesh towards " << z->getName() << " with a " << this->primaryWeapon << endl;
    int health = z->takeDamage(this->damage); // add take damage
    if (health <= 0)
        return true;

    return false;
}
void Cannibal::celebrate()
{
    cout << name << " Screams with his last breath, 'I am your father' " << endl;
}
bool Cannibal::getHit(SquadMember *z)
{
    cout << "The other villagers come running deploying" << endl;
    HP = HP - z->getDamage(); // add getDamage
    if (HP <= 0)
    {
        return true;
    }
    return false;
}
void Cannibal::die()
{
    cout << "Shakes his " << this->primaryWeapon << " at the players mains" << endl;
}

void Cannibal::setName(string name)
{
    this->name = name;
}
Cannibal::~Cannibal()
{
}