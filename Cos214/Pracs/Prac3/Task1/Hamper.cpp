#include "Hamper.h"
using namespace std;
Hamper::Hamper(string boxname, string boxDescription) : Confectionery()
{
    this->name = boxname;
    this->description = boxDescription;
}
void Hamper::addItem(Confectionery *name)
{
    ChockBox.push_back(name);
}
string Hamper::getBoxName()
{
    return this->name;
}
string Hamper::getBoxDescription()
{
    return this->description;
}
void Hamper::chockInfo()
{
    Confectionery *chock = ChockBox.back();

    cout << "|************HAMPER******************|" << endl;
    cout << "Basket Name: " + getBoxName() << endl
         << "Description: " + getBoxDescription() << endl;
    cout << "|------------CONTAINS----------------|" << endl;

    chock->getDescription();
    cout << "|************HAMPER******************|" << endl;
}

void Hamper::getDescription()
{
}
