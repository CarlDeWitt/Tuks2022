#include "Memento.h"

Memento::Memento()
{
    c = new careTaker();
}
SquadMember *Memento::getState()
{
    return c->getState();
}
void Memento::setMementoState(SquadMember *state)
{
    this->state = state;
    c->setState(state);
}