#include <iostream>
#include "Product.h"

using namespace std;

Product :: Product(string n, string d, double c):
        name(n),
        description(d),
        cost(c)
{
    state = new State();
}
    
string Product :: getName()
{
	return name;
}

void Product :: setName(string n)
{
	name = n;
}
     
string Product :: getDescription(){ return description;}

void Product :: setDescription(string d)
{
    description = d;
    state->setDescriptionChanged();
}
       
double Product :: getCost(){ return cost; }

void Product :: setCost(double c)
{
    cost = c;
    state->setCostChanged();
}

void Product :: display()
{
    cout << "\n" << name << ": " << description;
    cout << "  R" << cost << endl;
    state->showState();
}    
 
ProductBackup* Product :: makeBackup()
{
    return new ProductBackup(name, description, cost, state);
}

void Product :: restore(ProductBackup* mem)
{
        name = mem->getName();
        description = mem->getDescription();
        cost = mem->getCost();
        state = mem->getState();
}
