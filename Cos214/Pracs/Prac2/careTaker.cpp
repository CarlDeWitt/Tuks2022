#include "careTaker.h"

careTaker::careTaker()
{
}
careTaker::careTaker(SquadMember *state)
{
    this->state = state;
    backup();
    restore();
}

void careTaker::setState(SquadMember *state)
{
    this->state = state;
    backup();
}

void careTaker::backup()
{
    sm.push_back(state);
}
void careTaker::undo()
{
    sm.pop_back();
}

SquadMember *careTaker::getState()
{
    SquadMember *s = sm.front();
    undo();
    return s;
}

SquadMember *careTaker::restore()
{
    SquadMember *old = getState();
    cout << old->getName() << endl;
    // undo();
    return old;
}