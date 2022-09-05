#ifndef DIRECTORYITERATOR_H
#define DIRECTORYITERATOR_H
#include "NodeIterator.h"
#include "Folder.h"
#include "File.h"

class DirectoryIterator : public NodeIterator
{
private:
	Folder *f;
	vector<Node *> directoryCopy;
	int it = 0;

public:
	DirectoryIterator(vector<Node *> directory);
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
	~DirectoryIterator();
};

#endif
