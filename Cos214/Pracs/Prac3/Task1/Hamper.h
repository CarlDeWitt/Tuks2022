#pragma once

#include "Confectionery.h"
#include <vector>
#include <iterator> // for iterators

class Hamper : public Confectionery
{
private:
    vector<Confectionery *> ChockBox;
    string name;
    string description;

public:
    Hamper(string, string);
    string getBoxName();
    string getBoxDescription();
    void addItem(Confectionery *chockName);
    void chockInfo();
    void getDescription();
    vector<Confectionery *> getChockbox();
};