#ifndef MEMENTO_H
#define MEMENTO_H
#include <string>
#include "careTaker.h"

using namespace std;

class Memento
{
    friend class SquadMember;

private:
    SquadMember *state;
    careTaker *c;

public:
    Memento();
    SquadMember *getState();
    void setMementoState(SquadMember *);
};

#endif