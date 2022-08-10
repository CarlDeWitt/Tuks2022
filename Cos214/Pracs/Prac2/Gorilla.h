#ifndef GORILLA_H
#define GORILLA_H
#include <string>
#include "SquadMember.h"
#include "Enemy.h"

using namespace std;

class Gorilla : public Enemy
{
public:
    Gorilla(int hp, string attack, int damage, string defensive, string primaryWeapon);
    bool hitSquadMember(SquadMember *z);
    void celebrate();
    bool getHit(SquadMember *z);
    void die();
    void setName(string name);
    ~Gorilla();
};

#endif