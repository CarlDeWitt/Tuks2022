#include "Snake.h"

Snake::Snake(int hp, string attack, int damage, string defensive, string primaryWeapon) : Enemy(hp, attack, damage, defensive, primaryWeapon)
{
}

bool Snake::hitSquadMember(SquadMember *z)
{
    cout << "Snake " << name << " wraps around " << z->getName() << " and uses " << this->primaryWeapon << endl;
    int health = z->takeDamage(10); // add take damage
    if (health <= 0)
        return true;

    return false;
}
void Snake::celebrate()
{
    cout << name << " tried strongly till the end " << endl;
}
bool Snake::getHit(SquadMember *z)
{
    cout << "Slithers rapidly searching for safety and employs " << this->defensive << endl;
    HP = HP - z->getDamage(); // add getDamage
    if (HP <= 0)
    {
        return true;
    }
    return false;
}
void Snake::die()
{
    cout << "Hisses and curls up as he is defeated. " << endl;
}

void Snake::setName(string name)
{
    this->name = name;
}
Snake::~Snake()
{
}