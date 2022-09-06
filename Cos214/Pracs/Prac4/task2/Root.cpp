#include "Root.h"
Root::Root(vector<Node *> state)
{
    this->state = state;
}
void Root::setState(vector<Node *> state)
{
    this->state = state;
}
vector<Node *> Root::getState()
{
    return state;
}
void Root::clear()
{
    state.clear();
}
Root::~Root()
{
}
