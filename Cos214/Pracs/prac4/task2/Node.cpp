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

void Node::setDirectory(vector<Node *>)
{
    return;
}

Root *Node::create()
{
    return NULL;
}
void Node::restrore(Root *r)
{
    return;
}
void Node::clear()
{
}

void Node::setMacfee(Macfee *m)
{
    this->macfeeptr = m;
}

string Node::getContent()
{
    return "";
}

Node::~Node()
{
}
