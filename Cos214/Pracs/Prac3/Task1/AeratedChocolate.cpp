#include "AeratedChocolate.h"
#include "sstream"

AeratedChocolate::AeratedChocolate(string name, double price, int bubblespccm) : Confectionery(name, price, "AeratedChocolate") {
    this->bubblespccm = bubblespccm;
}

void AeratedChocolate::getDescription(){
    std::ostringstream s;
    s << this->price;
    string str = this->manufacturer + " created a Aerated Choclate for the price of:" + s.str() + " and has " + to_string(this->bubblespccm) + " bubbles per cm";
    cout << str << endl;
}