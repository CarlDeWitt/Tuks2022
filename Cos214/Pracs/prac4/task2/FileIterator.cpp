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
    cout << "Jake is a 🤡 and a big 📦" << endl;

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
    }
    else
    {
        it = 0;
        return false;
    }
    // return false;
}
Node *FileIterator::nextl()
{
    if (directoryCopy[it] != *directoryCopy.end())
    {
        if (directoryCopy[it]->type == "file")
        {
            return directoryCopy[++it];
        }
        else
        {
            it++;
            hasNext();
        }
    }
    else
    {
        it = -1;
        nextl();
    }
    return directoryCopy[++it];
}
Node *FileIterator::current()
{
    cout << "Jake is a 🤡 and a big 📦" << endl;

    return directoryCopy[it];
}

bool FileIterator::isEmpty()
{
    return directoryCopy.size() == 0;
}
bool FileIterator::listFile()
{
    return this->isEmpty();
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