#ifndef CARETAKER_H
#define CARETAKER_H
#include <string>
#include <vector>
#include "SquadMember.h"

using namespace std;

class careTaker
{
private:
    SquadMember *state;
    vector<SquadMember *> sm;

public:
    careTaker();
    careTaker(SquadMember *state);
    void backup();
    void undo();
    SquadMember *restore();
};

#endif