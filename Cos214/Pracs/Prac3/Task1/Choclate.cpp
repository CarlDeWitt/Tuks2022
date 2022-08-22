#include "Choclate.h"
#include <sstream>

Choclate::Choclate(string name, double price, bool slab) : Confectionery(name, price,"Choclate") {
    this->slab = slab;
}

void Choclate::getDescription(){
    std::ostringstream ss1;
    ss1 << this->price;
    string typeInfo = slab ? "slab" : "mini choclate";
    string str = this->manufacturer + " created a Choclate for the price of:" + ss1.str() + " and is a " + typeInfo;
    cout << str << endl;
}