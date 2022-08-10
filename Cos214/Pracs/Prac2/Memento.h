#ifndef MEMENTO_H
#define MEMENTO_H
#include <string>
#include "SquadMember.h"
#include "careTaker.h"

using namespace std;

class Memento
{
private:
    SquadMember *state;

public:
    Memento();
    SquadMember *getState();
    void setState(SquadMember *);
};

#endif