#include <iostream>
#include "string"
#include "AdventureIsland.h"
#include "SquadMember.h"

using namespace std;

int main()
{
    AdventureIsland *island = new AdventureIsland();

    island->makesquad("Carl", 50, 10);

    island->playgame(4);

    delete island;

    return 0;
}