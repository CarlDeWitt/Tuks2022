#include "LindtFactory.h"

LindtFactory::LindtFactory()
{
}

Confectionery* LindtFactory::createChocolate(bool i){
    
    return new Lindt(i);
}
Confectionery* LindtFactory::createAeratedChocolate(int b){
    cout << "Aerated Chocolate not available" << endl;
    return NULL;
}