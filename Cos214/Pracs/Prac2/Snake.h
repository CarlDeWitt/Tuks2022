#ifndef SNAKE_H
#define SNAKE_H
#include <string>
#include "SquadMember.h"
#include "Enemy.h"

using namespace std;

class Snake : public Enemy
{
public:
    Snake(int hp, string attack, int damage, string defensive, string primaryWeapon);
    bool hitSquadMember(SquadMember *z);
    void celebrate();
    bool getHit(SquadMember *z);
    void die();
    void setName(string name);
    ~Snake();
};

#endif