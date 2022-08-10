#ifndef ENEMYFACTORY_H
#define ENEMYFACTORY_H
#include <string>
#include <stdlib.h> /* srand, rand */
#include <time.h>   /* time */
#include "Enemy.h"
#include <random>

using namespace std;

class EnemyFactory
{
private:
    string name[10];

public:
    EnemyFactory();
    string getName();
    // ~EnemyFactory();
    virtual Enemy *createEnemy(string attack, string defense) = 0;
};

#endif