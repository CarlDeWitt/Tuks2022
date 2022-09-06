#pragma once

#include <vector>
#include "Root.h"

class Caretaker
{
private:
    vector<Root *> states;

public:
    Caretaker();
    void doo(Root *state);
    Root *undo();
    void clear();
    ~Caretaker();
};
