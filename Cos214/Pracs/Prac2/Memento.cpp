#include "Memento.h"

Memento::Memento()
{
}
SquadMember *Memento::getState()
{
    careTaker c(state);
}
void Memento::setState(SquadMember *state)
{
    this->state = state;
}