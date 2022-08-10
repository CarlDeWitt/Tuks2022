#include <iostream>
#include "string"
#include "AdventureIsland.h"
#include "SquadMember.h"
#include "careTaker.h"

using namespace std;

int main()
{
    AdventureIsland *island = new AdventureIsland();
    careTaker *t = new careTaker();
    SquadMember *mem;

    island->makesquad("Carl", 50, 10);
    island->saveSquadMember();

    // mem = t->restore();

    // cout << "Name is: " + mem->getName() << endl;

    // island->playgame(4);

    delete island;

    return 0;
}