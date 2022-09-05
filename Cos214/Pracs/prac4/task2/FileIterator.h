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
    bool hasNext();
    bool listDirectory();
    bool isEmpty();
    bool listFile();
    void addDirectory(Folder *);
    void removeDirectory();
    void addFile(File *);
    void removeFile();
    ~FileIterator();
};
