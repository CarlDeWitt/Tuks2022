#ifndef ADVENTUREISLAND_H
#define ADVENTUREISLAND_H
using namespace std;
#include "SquadMember.h"
#include "Enemy.h"
#include "EnemyFactory.h"
#include "SnakeFactory.h"
#include "GorillaFactory.h"
#include "JaguarFactory.h"
#include "CannibalFactory.h"

class AdventureIsland
{
private:
    SquadMember *squad1;
    EnemyFactory *sfac;
    EnemyFactory *gfac;
    EnemyFactory *cfac;
    EnemyFactory *jfac;
    Enemy *s;
    Enemy *g;
    Enemy *c;
    Enemy *j;
    void makeEns();

public:
    AdventureIsland();
    void nameEnemy(string, string);
    void makesquad(string, int, int);
    void playgame(int);
    SquadMember *cloneSquad();
    void saveSquadMember();
    ~AdventureIsland();
};

#endif