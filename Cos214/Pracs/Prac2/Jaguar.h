#ifndef JAGUAR_H
#define JAGUAR_H
#include <string>
#include "SquadMember.h"
#include "Enemy.h"

using namespace std;

class Jaguar : public Enemy
{
public:
    Jaguar(int hp, string attack, int damage, string defensive, string primaryWeapon);
    bool hitSquadMember(SquadMember *z);
    void celebrate();
    bool getHit(SquadMember *z);
    void die();
    void setName(string name);
    ~Jaguar();
};

#endif