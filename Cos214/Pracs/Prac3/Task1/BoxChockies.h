#pragma once

#include "Basket.h"
#include <vector>
#include <iterator> // for iterators

class BoxChockies : public Basket
{
private:
    vector<Basket *> ChockBox;
    string boxname;
    string boxDescription;

public:
    BoxChockies(string, string);
    string getBoxName();
    string getBoxDescription();
    void addItem(Basket *chockName);
    void removeItem();
    void chockInfo();
    // ~BoxChockies();
};