#include <iostream>
#include "string"
#include "AdventureIsland.h"
#include "SquadMember.h"

using namespace std;

int main()
{
    AdventureIsland *island = new AdventureIsland();
    // careTaker *t = new careTaker();
    SquadMember *mem;

    island->makesquad("Carl", 50, 10);
    island->saveSquadMember();
    island->restoreSquad();

    // mem = t->restore

    // cout << t->restore() << endl;

    // mem = t->restore();
    // cout << mem << endl;

    // island->playgame(4);
    delete island;

    return 0;
}