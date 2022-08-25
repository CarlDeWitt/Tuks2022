#include "BoxChockies.h"
using namespace std;
BoxChockies::BoxChockies(string boxname, string boxDescription)
{
    this->boxname = boxname;
    this->boxDescription = boxDescription;
}
void BoxChockies::addItem(Basket *name)
{
    ChockBox.push_back(name);
}
void BoxChockies::removeItem()
{
    ChockBox.pop_back();
}
string BoxChockies::getBoxName()
{
    return this->boxname;
}
string BoxChockies::getBoxDescription()
{
    return this->boxDescription;
}
void BoxChockies::chockInfo()
{
    cout << "Basket Name: " + getBoxName() + " Description: " + getBoxDescription() << endl;

    vector<Basket *>::iterator ptr;

    for (ptr = ChockBox.begin(); ptr < ChockBox.end(); ptr++)
    {
        Basket *chock = *ptr;
        chock->chockInfo();
    }
}
// BoxChockies::~BoxChockies() {}
