#pragma once
#include <vector>
#include "Node.h"
using namespace std;

class Node;

class Root
{
private:
    vector<Node *> state;

public:
    Root(vector<Node *> state);
    void setState(vector<Node *>);
    vector<Node *> getState();
    void clear();
    ~Root();
};
