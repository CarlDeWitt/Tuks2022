#include "Enemy.h"

Enemy::Enemy(int hp, string attack, int damage, string defensive, string primaryWeapon)
{
    this->HP = hp;
    this->atk = attack;
    this->damage = damage;
    this->primaryWeapon = primaryWeapon;
    this->defensive = defensive;
    // this->name = name;
}

void Enemy::attack(SquadMember *n)
{
    while (n->HP > 0 && this->HP > 0 && this->isalive() && n->isAlive())
    {
        if (this->hitSquadMember(n))
        {
            n->die();
            this->celebrate();
            break;
        }
        else
        {
            if (this->getHit(n))
            {
                this->die();
            }
        }
    }
}

bool Enemy::isalive()
{
    return this->HP > 0;
}