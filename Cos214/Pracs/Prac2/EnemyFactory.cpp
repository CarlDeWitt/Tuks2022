#include "EnemyFactory.h"

EnemyFactory::EnemyFactory()
{
    name[0] = "Artemis";
    name[1] = "Branwen";
    name[2] = "Dalia";
    name[3] = "Eluned";
    name[4] = "Embla";
    name[5] = "Niamh";
    name[6] = "Pax";
    name[7] = "Persephone";
    name[8] = "Saga";
    name[9] = "Alberich";
    // name[10] = "Evander";
}

string EnemyFactory::getName()
{
    srand(time(NULL));
    int random = rand() % 10;

    return name[random];
}