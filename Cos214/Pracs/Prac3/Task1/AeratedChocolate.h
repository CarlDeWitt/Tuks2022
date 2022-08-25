#ifndef AERATEDCHOCOLATE_H
#define AERATEDCHOCOLATE_H
#include "Confectionery.h"

class AeratedChocolate : public Confectionery
{
private:
    int bubblespccm;

public:
    AeratedChocolate(string, double, int);
    void getDescription();
    // virtual ~AeratedChocolate();
};

#endif
