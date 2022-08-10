#include "CannibalFactory.h"

CannibalFactory::CannibalFactory()
{
}

Enemy *CannibalFactory::createEnemy(string attack, string defense)
{
    default_random_engine generator;
    normal_distribution<double> distribution(30, 8);
    int hp = distribution(generator);
    Enemy *c = new Cannibal(hp, attack, 6, defense, attack);
    return c;
}