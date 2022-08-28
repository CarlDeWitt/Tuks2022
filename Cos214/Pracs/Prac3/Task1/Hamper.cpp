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
    int size = 0;
    cout << ChockBox.size() << endl;

    cout << "|************HAMPER******************|" << endl;
    cout << "Basket Name: " + getBoxName() << endl
         << "Description: " + getBoxDescription() << endl;
    cout << "|------------CONTAINS----------------|" << endl;

    for (Confectionery *e : ChockBox)
    {
        e->getDescription();
    }
    cout << "|************HAMPER******************|" << endl;
}

vector<Confectionery *> Hamper::getChockbox()
{
    return ChockBox;
}

void Hamper::getDescription()
{
}
