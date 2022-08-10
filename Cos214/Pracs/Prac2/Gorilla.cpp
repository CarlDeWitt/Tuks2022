#include "Gorilla.h"

Gorilla::Gorilla(int hp, string attack, int damage, string defensive, string primaryWeapon) : Enemy(hp, attack, damage, defensive, primaryWeapon)
{
}

bool Gorilla::hitSquadMember(SquadMember *z)
{
    cout << "Gorilla " << name << " slams his fists on the ground, growls and hits" << z->getName() << "with " << this->primaryWeapon << endl;
    int health = z->takeDamage(10); // add take damage
    if (health <= 0)
        return true;

    return false;
}
void Gorilla::celebrate()
{
    cout << name << " tried in vain trying to save himself." << endl;
}
bool Gorilla::getHit(SquadMember *z)
{
    cout << "Roars and hits his chest in anger." << endl;
    HP = HP - z->getDamage(); // add getDamage
    if (HP <= 0)
    {
        return true;
    }
    return false;
}
void Gorilla::die()
{
    cout << "The earth shakes as the gorilla falls to the ground." << endl;
}

void Gorilla::setName(string name)
{
    this->name = name;
}
// Gorilla::~Gorilla()
// {
//     cout << "Gorilla destuct" << endl;
// }