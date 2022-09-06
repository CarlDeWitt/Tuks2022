#ifndef PRODUCT_STATE_MEMORY_H
#define PRODUCT_STATE_MEMORY_H

#include "ProductBackup.h"

class ProductStateMemory
{
    public:
        ProductStateMemory();
        ProductBackup* getMemento();
        void setMemento(ProductBackup*);
    private:
        ProductBackup* memento;
};
#endif
