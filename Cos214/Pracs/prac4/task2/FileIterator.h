#pragma
#include "NodeIterator.h"
#include "Folder.h"
#include "File.h"

class FileIterator : public NodeIterator
{
private:
    Folder *f;
    vector<Node *> directoryCopy;
    int it = 0;

public:
    FileIterator(vector<Node *> directory);
    Node *first();
    Node *next();
    Node *current();
    Node *nextl();
    bool hasNext();
    bool isEmpty();
    bool listFile();
    void addFile(File *);
    void removeFile();
    ~FileIterator();
};
