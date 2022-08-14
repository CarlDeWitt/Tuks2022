#ifndef SQUADMEMBER_H
#define SQUADMEMBER_H
#include "string"
#include "iostream"
// #include "Memento.h"

using namespace std;

class SquadMember
{
private:
    bool alive;
    int damage;
    string name;
    // Memento *mt;

public:
    int HP;
    SquadMember(string name, int hp, bool alive, int damage);
    SquadMember();
    SquadMember *Clone(); // make pntr
    bool isAlive();
    int getHP();
    void setHP(int);
    void setDamage(int);
    void die();
    int takeDamage(int damage);
    string getName();
    int getDamage();
    void savestate();
    SquadMember *restorestate();
    ~SquadMember();
};
#endif