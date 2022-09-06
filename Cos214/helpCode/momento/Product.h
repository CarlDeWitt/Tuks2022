#ifndef PRODUCT_H
#define PRODUCT_H

#include <string>

#include "State.h"
#include "ProductBackup.h"

class Product
{
    public:
        Product(string, string, double);
        
        string getName();
        void setName(string n);
        
        string getDescription();
        void setDescription(string d);
        
        double getCost();
        void setCost(double cost);
        
        State* getState(){return state;};
        
        void display();
        ProductBackup* makeBackup();
        void restore(ProductBackup*);
    
    private:    
        string name;
        string description;
        double cost;
        State* state;
};
#endif