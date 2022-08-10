#include "JaguarFactory.h"

JaguarFactory::JaguarFactory()
{
}

Enemy *JaguarFactory::createEnemy(string attack, string defense)
{
    default_random_engine generator;
    normal_distribution<double> distribution(10, 3);
    int hp = distribution(generator);
    Enemy *j = new Jaguar(hp, attack, 4, defense, attack);
    return j;
}