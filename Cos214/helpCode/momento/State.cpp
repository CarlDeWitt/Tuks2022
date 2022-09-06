#include "State.h"

State :: State():
        nameChanged (false),
        descriptionChanged (false),
        costChanged (false)
{}

State :: State(const State& s) :
    nameChanged (s.nameChanged),
    descriptionChanged (s.descriptionChanged),
    costChanged (s.costChanged)
{}

void State :: setNameChanged(){ nameChanged = true;}

void State :: setDescriptionChanged(){ descriptionChanged = true; }

void State :: setCostChanged(){ costChanged = true; }

void State :: showState()
{
    if (nameChanged || descriptionChanged || costChanged)
    {
        cout << "The following has changed: ";
        if (nameChanged) {cout << "name ";};
        if (descriptionChanged) {cout << "description ";};
        if (costChanged){cout  << "cost ";};
        cout << endl;
    }
    else { cout << "Nothing has changed" << endl; }
}
