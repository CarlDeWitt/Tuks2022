#pragma once

#include "Confectionery.h"
#include <vector>
#include <iterator> // for iterators

class Hamper : public Confectionery
{
private:
    vector<Confectionery *> ChockBox;

public:
    Hamper();
    string getBoxName();
    string getBoxDescription();
    void addItem(Confectionery *chockName);
    void chockInfo();
};