#include "careTaker.h"

careTaker::careTaker()
{
}
careTaker::careTaker(SquadMember *state)
{
    cout << "hello here" << endl;
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
    SquadMember *old = state;
    undo();
    return old;
}