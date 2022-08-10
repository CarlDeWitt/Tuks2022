#ifndef ENEMY_H
#define ENEMY_H
#include <string>
#include "SquadMember.h"

using namespace std;

class Enemy
{
protected:
    int HP;
    int damage;
    string atk;
    string name;
    string defensive;
    string primaryWeapon;

public:
    Enemy(int hp, string attack, int damage, string defensive, string primaryWeapon);
    bool isalive();
    void attack(SquadMember *n);
    virtual bool hitSquadMember(SquadMember *z) = 0;
    virtual void celebrate() = 0;
    virtual bool getHit(SquadMember *z) = 0;
    virtual void die() = 0;
    virtual void setName(string name) = 0;
    // virtual ~Enemy();
};

#endif