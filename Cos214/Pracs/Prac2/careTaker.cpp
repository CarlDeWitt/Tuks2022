#include "careTaker.h"

careTaker::careTaker()
{
}
careTaker::careTaker(SquadMember *state)
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

SquadMember *careTaker::restore()
{
    SquadMember *old = this->state;
    undo();
    return old;
}