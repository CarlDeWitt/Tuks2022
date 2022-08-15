#ifndef CHOCOLATE_H
#define CHOCOLATE_H

class Chocolate : public Sweet {
public:
    Chocolate();
    virtual void wrap();
protected:
    virtual void print();
        int id_;
    static int total_;
};

#endif