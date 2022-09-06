#include "Caretaker.h"

Caretaker::Caretaker()
{
}
void Caretaker::doo(Root *state)
{
    states.push_back(state);
}
Root *Caretaker::undo()
{
    Root *state = states.back();
    states.pop_back();
    return state;
}
void Caretaker::clear()
{
    states.clear();
}
Caretaker::~Caretaker() {}
