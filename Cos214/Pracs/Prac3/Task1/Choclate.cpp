#include "Choclate.h"
#include <sstream>

Choclate::Choclate(string name, double price, bool slab) : Confectionery(name, price, "Choclate")
{
    this->slab = slab;
}

void Choclate::getDescription()
{
    std::ostringstream ss1;
    ss1 << this->getPrice();
    string typeInfo = slab ? "slab" : "mini choclate";
    string str = this->getManufacturer() + " created a Choclate for the price of R" + ss1.str() + " and is a " + typeInfo;
    cout << str << endl;
}