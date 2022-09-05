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
    return directoryCopy[it++];
}

bool DirectoryIterator::hasNext()
{
    if (directoryCopy[it] != *directoryCopy.end())
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
        // cout << directoryCopy[it]->type << endl;
        // return true;
    }
    else
    {
        return false;
    }
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
    else
    {
        return false;
    }
}
bool DirectoryIterator::isEmpty()
{
    return directoryCopy.size() == 0;
}
bool DirectoryIterator::listFile()
{
    return false;
}
void DirectoryIterator::addDirectory(Folder *f)
{
    directoryCopy.push_back(f);
}
void DirectoryIterator::removeDirectory()
{
    directoryCopy.pop_back();
}
void DirectoryIterator::addFile(File *f)
{
    return;
}
void DirectoryIterator::removeFile()
{
    return;
}

DirectoryIterator::~DirectoryIterator()
{
}