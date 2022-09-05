#include "FileIterator.h"

FileIterator::FileIterator(vector<Node *> directory) : NodeIterator()
{
    directoryCopy = directory;
    it = 0;
}
Node *FileIterator::first()
{
    return directoryCopy[0];
}
Node *FileIterator::next()
{
    return directoryCopy[it++];
}

bool FileIterator::hasNext()
{
    if (directoryCopy[it] != *directoryCopy.end())
    {
        if (directoryCopy[it]->type == "file")
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
Node *FileIterator::current()
{
    return directoryCopy[it];
}

bool FileIterator::listDirectory()
{
    return false;
}
bool FileIterator::isEmpty()
{
    return directoryCopy.size() == 0;
}
bool FileIterator::listFile()
{
    while (directoryCopy[it] != *directoryCopy.end())
    {
        if (directoryCopy[it]->type == "file")
        {
            directoryCopy[it++]->list();
            return true;
        }
        else
        {
            return false;
        }
    }
}
void FileIterator::addDirectory(Folder *f)
{
    return;
}
void FileIterator::removeDirectory()
{
    return;
}
void FileIterator::addFile(File *f)
{
    directoryCopy.push_back(f);
}
void FileIterator::removeFile()
{
    directoryCopy.pop_back();
}

FileIterator::~FileIterator()
{
}