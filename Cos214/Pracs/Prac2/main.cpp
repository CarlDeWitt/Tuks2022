#include <iostream>
#include "string"
#include "AdventureIsland.h"
#include "SquadMember.h"

using namespace std;

void run1()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * @param numOfEnemies
     * @vars Island *island
     *
     */
    AdventureIsland *island = new AdventureIsland();
    SquadMember *mem;

    island->makesquad("Carl", 70, 15);
    island->playgame(4);
    delete island;
}

void run2()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */
    AdventureIsland *island = new AdventureIsland();
    SquadMember *mem;

    island->makesquad("Carl", 30, 10);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    delete island;
}

void run3()
{
    /**
     * @brief this game will be played and the squad member will attack all 2 enemies 4 times the enemies will defeat the character if there is no memento being applied
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */
    AdventureIsland *island = new AdventureIsland();
    SquadMember *mem;

    island->makesquad("Carl", 30, 10);
    island->playgame(2);
    island->playgame(2);
    island->playgame(2);
    island->playgame(2);
    delete island;
}
void run4()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */
    AdventureIsland *island = new AdventureIsland();
    SquadMember *mem;

    island->makesquad("Carl", 30, 10);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    delete island;
}
int main()
{
    run1();
    // run2();
    // run3();
    // run4();

    return 0;
}