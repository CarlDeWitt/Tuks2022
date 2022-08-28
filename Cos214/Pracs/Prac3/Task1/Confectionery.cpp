#include "Confectionery.h"
int index = 0;
Confectionery::Confectionery(string manufacturer, double price, string type)
{
    this->manufacturer = manufacturer;
    this->price = price;
    this->type = type;
    this->id = index++;
}

double Confectionery::getPrice()
{
    return this->price;
}

string Confectionery::getManufacturer()
{
    return this->manufacturer;
}
string Confectionery::getType()
{
    return this->type;
}
void Confectionery::setPrice(double price)
{
    this->price = price;
}
void Confectionery::setManufacturer(string s)
{
    this->manufacturer = s;
}
void Confectionery::setType(string s)
{
    this->type = s;
}

Confectionery::Confectionery()
{
}