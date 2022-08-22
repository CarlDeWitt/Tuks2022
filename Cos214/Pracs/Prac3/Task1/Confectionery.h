#ifndef CONFECTIONERY_H
#define CONFECTIONERY_H
#include <string>
using namespace std;
#include <iostream>

class Confectionery {
    public:
        string manufacturer;
        double price;
        string type;
        int id;
    public:
        Confectionery(string, double, string);
        virtual void getDescription() = 0;
};

#endif
