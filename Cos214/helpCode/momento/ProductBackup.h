#ifndef PRODUCT_BACKUP
#define PRODUCT_BACKUP

#include "State.h"

class ProductBackup
{
    public:
        ProductBackup(string n, string d, double c, State* s);
        string getName(){return name;};        
        string getDescription(){return description;};        
        double getCost(){return cost;};        
        State* getState(){return state;};
    private:    
        string name;
        string description;
        double cost;
        State* state;
};
#endif