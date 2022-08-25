#include "Checkout.h"
Checkout::Checkout(Basket *box)
{
    this->box = box;
}
void Checkout::displayItmes()
{
    box->chockInfo();
}
// Checkout::~Checkout() {}
