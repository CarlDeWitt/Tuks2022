#ifndef CANNIBAL_H
#define CANNIBAL_H
#include <string>
#include "SquadMember.h"
#include "Enemy.h"

using namespace std;

class Cannibal : public Enemy
{
public:
    Cannibal(int hp, string attack, int damage, string defensive, string primaryWeapon);
    bool hitSquadMember(SquadMember *z);
    void celebrate();
    bool getHit(SquadMember *z);
    void die();
    void setName(string name);
    ~Cannibal();
};

#endif