#include "Memento.h"

Memento::Memento()
{
}
void Memento::getState()
{
}
void Memento::setState(SquadMember *state)
{
    this->state = state;
    careTaker *c = new careTaker(state);
}