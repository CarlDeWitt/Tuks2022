#ifndef COMBATANT_H
#define COMBATANT_H

#include <iostream>
#include <string>
#include <random>
#include <cpp-terminal/constants.hpp>

using namespace std;

class Combatant {
  private:
    int energy;
    int shield;
    int score;
    string name;

  public:
    Combatant(string);
    ~Combatant();
    int getEnergy() { return this->energy; }
    int getScore() { return this->score; }
    int getShield() { return this->shield; }
    string getName() { return this->name; }
    void rechargeBattery();
    void activateBarrier(int);
    void zapEnergy(Combatant*, int);
    int receiveDamage(int);
};

#endif
