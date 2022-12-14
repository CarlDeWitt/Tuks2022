#include "DirectoryIterator.h"

DirectoryIterator::DirectoryIterator(vector<Node *> directory) : NodeIterator()
{
    directoryCopy = directory;
    it = 0;
}
Node *DirectoryIterator::first()
{
    return directoryCopy[0];
}
Node *DirectoryIterator::next()
{
    return directoryCopy[++it];
}

bool DirectoryIterator::hasNext()
{
    if (directoryCopy[it + 1] != *directoryCopy.end())
    {
        if (directoryCopy[it]->type == "folder")
        {
            return true;
        }
        else
        {
            it++;
            hasNext();
        }
    }
    else
    {
        return false;
    }
    // return false;
}

Node *DirectoryIterator::nextl()
{
    if (directoryCopy[it + 1] == *directoryCopy.end())
    {
        it = -1;
    }
    return directoryCopy[++it];
}
Node *DirectoryIterator::current()
{
    return directoryCopy[it];
}

bool DirectoryIterator::listDirectory()
{
    if (directoryCopy[it]->type == "folder")
    {
        directoryCopy[it]->list();
        return true;
    }
    return false;
}
bool DirectoryIterator::isEmpty()
{
    return directoryCopy.size() == 0;
}
void DirectoryIterator::addDirectory(Folder *f)
{
    directoryCopy.push_back(f);
}
void DirectoryIterator::removeDirectory()
{
    directoryCopy.pop_back();
}

DirectoryIterator::~DirectoryIterator()
{
}