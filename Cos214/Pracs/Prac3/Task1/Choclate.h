#ifndef CHOCLATE_H
#define CHOCLATE_H
#include "Confectionery.h"

class Choclate : public Confectionery {
    private:
        bool slab;
    public:
        Choclate(string, double, bool);
        void getDescription();
};  

#endif
