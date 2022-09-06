#include "ProductStateMemory.h"

ProductStateMemory :: ProductStateMemory():
    memento(0)
{}
    
ProductBackup* ProductStateMemory :: getMemento(){ return memento; }

void ProductStateMemory :: setMemento(ProductBackup* m)
{
    memento = m;
}
