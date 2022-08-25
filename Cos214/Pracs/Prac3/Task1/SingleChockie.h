#pragma once

#include "Basket.h"

class SingleChockie : public Basket
{
private:
    string manufacturer;
    double price;
    string type;

public:
    SingleChockie(string, double, string);
    string getManufacturer();
    double getPrice();
    string getType();
    void addItem(Basket *chockName);
    void removeItem();
    void chockInfo();
};