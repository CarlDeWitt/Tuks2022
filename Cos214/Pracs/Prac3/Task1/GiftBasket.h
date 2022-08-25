#pragma once

#include "Confectionery.h"
#include <vector>
#include <iterator> // for iterators

class BoxChockies : public Confectionery
{
private:
    vector<Confectionery *> ChockBox;
    string boxname;
    string boxDescription;

public:
    BoxChockies(string, string);
    string getBoxName();
    string getBoxDescription();
    void addItem(Confectionery *chockName);
    void removeItem();
    void chockInfo();
    // ~BoxChockies();
};