#include "GorillaFactory.h"

GorillaFactory::GorillaFactory()
{
}

Enemy *GorillaFactory::createEnemy(string attack, string defense)
{
    default_random_engine generator;
    normal_distribution<double> distribution(4, 12.0);
    int hp = distribution(generator);
    Enemy *g = new Gorilla(hp, attack, 1, defense, attack);
    return g;
}