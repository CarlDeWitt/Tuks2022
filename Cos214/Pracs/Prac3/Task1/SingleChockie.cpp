#include "SingleChockie.h"
using namespace std;
SingleChockie::SingleChockie(string manufacturer, double price, string type)
{
    this->manufacturer = manufacturer;
    this->price = price;
    this->type = type;
}

string SingleChockie::getManufacturer()
{
    return this->manufacturer;
}

double SingleChockie::getPrice()
{
    return this->price;
}
string SingleChockie::getType()
{
    return this->type;
}
void SingleChockie::chockInfo()
{

    cout << "SingleChockie: " << this->manufacturer << " R" << this->price << " " << this->type << endl;
}

void SingleChockie::addItem(Basket *chockName)
{
}
void SingleChockie::removeItem()
{
}
// SingleChockie::~SingleChockie(){}
