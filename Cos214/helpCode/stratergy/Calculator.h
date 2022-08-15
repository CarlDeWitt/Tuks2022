#ifndef CALCULATOR_H
#define CALCULATOR_H


class Calculator {
public:
    virtual int execute(int a, int b) = 0;
    virtual ~Calculator();
};

class Add : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Add();
};

class Subtract : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Subtract();
};

class Multiply : public Calculator {
public:
    virtual int execute(int a, int b);
    ~Multiply();
};



#endif

