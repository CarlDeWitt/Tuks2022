#include "Confectionery.h"
int index = 0;
Confectionery::Confectionery(string manufacturer, double price, string type)
{
    this->manufacturer = manufacturer;
    this->price = price;
    this->type = type;
    this->id = index++;
}

Confectionery::Confectionery()
{
}