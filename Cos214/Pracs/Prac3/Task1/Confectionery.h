#ifndef CONFECTIONERY_H
#define CONFECTIONERY_H
#include <string>
using namespace std;
#include <iostream>

class Confectionery
{
private:
    string manufacturer;
    string type;
    double price;
    int id;

public:
    Confectionery();
    Confectionery(string, double, string);
    virtual void getDescription() = 0;
    double getPrice();
    string getManufacturer();
    string getType();
    void setPrice(double);
    void setManufacturer(string);
    void setType(string);
    // virtual ~Confectionery();
};

#endif
