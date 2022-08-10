#ifndef JAGUARFACTORY_H
#define JAGUARFACTORY_H
#include "EnemyFactory.h"
#include "Jaguar.h"

class JaguarFactory : public EnemyFactory
{
public:
    JaguarFactory();
    ~JaguarFactory();
    Enemy *createEnemy(string attack, string defense);
};

#endif