#include "NestleFactory.h"
NestleFactory::NestleFactory()
{
}

Confectionery* NestleFactory::createChocolate(bool b){
    return new MilkyBar(b);
}
Confectionery* NestleFactory::createAeratedChocolate(int i){
    return new Areo(i);
}