#ifndef STATE_H
#define STATE_H

#include <iostream>

using namespace std;

class State
{
    public:
        State();
        State(const State& s);   // copy constructor
        void setNameChanged();
        void setDescriptionChanged();
        void setCostChanged();
        void showState();
    private:
        bool nameChanged;
        bool descriptionChanged;
        bool costChanged;
};
#endif
