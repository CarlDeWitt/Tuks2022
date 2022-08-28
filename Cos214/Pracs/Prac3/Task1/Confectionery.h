#ifndef CONFECTIONERY_H
#define CONFECTIONERY_H
#include <string>
using namespace std;
#include <iostream>

class Confectionery
{
public:
    string manufacturer;
    string type;
    double price;
    int id;
    Confectionery();
    Confectionery(string, double, string);
    virtual void getDescription() = 0;
    double getPrice();
    // virtual ~Confectionery();
};

#endif
