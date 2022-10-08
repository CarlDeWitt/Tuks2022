#pragma once
#include <iostream>
using namespace std;

class Unit
{
private:
    int HP;
    int damage;

public:
    Unit(int HP, int damage);
    int getHP();
    int setDamage(int damage);
    void setHP(int HP);
    void setHP();
    virtual void primitiveAttack() = 0;
    virtual void attack(Unit *unit) = 0;
    virtual void primitiveDefend() = 0;
    virtual void defend(Unit *unit) = 0;
    virtual Unit *clone() = 0;
    virtual ~Unit();
};
