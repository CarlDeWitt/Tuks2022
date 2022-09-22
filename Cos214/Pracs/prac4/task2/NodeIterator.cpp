#include "NodeIterator.h"

NodeIterator::NodeIterator()
{
}

Node *NodeIterator::first()
{
    return NULL;
}
Node *NodeIterator::next()
{
    return NULL;
}

Node *NodeIterator::nextl()
{
    return NULL;
}
bool NodeIterator::hasNext()
{
    return false;
}
Node *NodeIterator::current()
{
    return NULL;
}
bool NodeIterator::listDirectory()
{
    return false;
}
bool NodeIterator::isEmpty()
{
    return false;
}
bool NodeIterator::listFile()
{
    return false;
}
void NodeIterator::addDirectory(Folder *)
{
}
void NodeIterator::removeDirectory()
{
}
void NodeIterator::addFile(File *)
{
}
void NodeIterator::removeFile()
{
}

NodeIterator::~NodeIterator()
{
}