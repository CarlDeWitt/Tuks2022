#include "Node.h"

Node::Node(string type, string name)
{
    this->type = type;
    this->name = name;
}

vector<Node *> Node::getDirectory()
{
    return vector<Node *>();
}

Node::~Node()
{
}
