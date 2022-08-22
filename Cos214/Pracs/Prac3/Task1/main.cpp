#include "Areo.h"
#include "Lindt.h"
#include "Confectionery.h"
#include "AeratedChocolate.h"
#include <iostream>
#include "string"

using namespace std;

int main(){

    Confectionery *areo = new Areo();
     Confectionery *lindt = new Lindor();


    areo->getDescription();
    lindt->getDescription();

    delete areo;

    return 0;
}