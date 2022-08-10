#include "SnakeFactory.h"

SnakeFactory::SnakeFactory()
{
}

Enemy *SnakeFactory::createEnemy(string attack, string defense)
{
    default_random_engine generator;
    normal_distribution<double> distribution(6.0, 1.0);
    int hp = distribution(generator);
    Enemy *snake = new Snake(hp, attack, 2, defense, attack);
    return snake;
}