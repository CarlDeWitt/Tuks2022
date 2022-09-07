#pragma once

#include "Node.h"
#include <iostream>
#include <string>

using namespace std;

class Node;

class Macfee

{
private:
public:
    Macfee();
    virtual void VirusCheck(Node *) = 0;
    virtual ~Macfee();
};
