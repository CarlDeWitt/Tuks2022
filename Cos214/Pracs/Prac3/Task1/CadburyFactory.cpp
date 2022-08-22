#include "CadburyFactory.h"


CadburyFactory::CadburyFactory(): ConfectioneryFactory()
{
}
Confectionery* CadburyFactory::createChocolate(bool n){
    return new DiaryMilk(n);
}
Confectionery* CadburyFactory::createAeratedChocolate(int b){
    return new DiaryMilkBubbly(b);
}