#include "AdventureIsland.h"

AdventureIsland::AdventureIsland()
{
    makeEns();
}

void AdventureIsland::makesquad(string name, int hp, int dam)
{
    squad1 = new SquadMember(name, hp, true, dam);
}

void AdventureIsland::makeEns()
{
    sfac = new SnakeFactory();
    gfac = new GorillaFactory();
    cfac = new CannibalFactory();
    jfac = new JaguarFactory();
    s = sfac->createEnemy("fangs", "skin");
    g = gfac->createEnemy("arms", "brain");
    c = cfac->createEnemy("munch", "Gorilla noises");
    j = jfac->createEnemy("claws", "speed");
}

void AdventureIsland::saveSquadMember()
{
    if (squad1)
    {
        squad1->savestate();
    }
}

void AdventureIsland::playgame(int e)
{
    if (e >= 1)
    {
        s->setName(sfac->getName());
        cout << "You are attacking the snake now: " << endl;
        s->attack(squad1);
        cout << endl;
        while (s->isalive())
        {
            s->attack(squad1);
        }
    }

    if (e >= 2)
    {
        j->setName(jfac->getName());
        cout << "You are attacking the jake now " << endl;
        j->attack(squad1);
        cout << endl;
        while (j->isalive())
        {
            j->attack(squad1);
        }
    }

    if (e >= 3)
    {
        g->setName(gfac->getName());
        cout << "You are attacking the gorilla now " << endl;
        g->attack(squad1);
        cout << endl;
        while (g->isalive())
        {
            g->attack(squad1);
        }
    }

    if (e >= 4)
    {

        c->setName(cfac->getName());
        cout << "You are attacking the cannibal now " << endl;
        c->attack(squad1);
        cout << endl;
        while (c->isalive())
        {
            c->attack(squad1);
        }
    }
}

void AdventureIsland::nameEnemy(string type, string name)
{
    if (type == "snake")
    {
        s->setName(name);
    }
    if (type == "gorilla")
    {
        g->setName(name);
    }
    if (type == "jaguar")
    {
        j->setName(name);
    }
    if (type == "cannibal")
    {
        c->setName(name);
    }
}

SquadMember *AdventureIsland::cloneSquad()
{
    SquadMember *newsquad = squad1->Clone();
    return newsquad;
}

AdventureIsland::~AdventureIsland()
{
    delete sfac;
    delete gfac;
    delete cfac;
    delete jfac;
}

void AdventureIsland::restoreSquad()
{
    this->squad1 = squad1->restorestate();
}
