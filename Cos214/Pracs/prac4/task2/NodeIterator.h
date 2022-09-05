#ifndef NODEITERATOR_H
#define NODEITERATOR_H

#include "Node.h"
#include "Folder.h"
#include "File.h"

class NodeIterator
{

public:
	NodeIterator();
	virtual Node *first() = 0;
	virtual Node *next() = 0;
	virtual bool hasNext() = 0;
	virtual Node *current() = 0;
	virtual bool listDirectory() = 0;
	virtual bool isEmpty() = 0;
	virtual bool listFile() = 0;
	virtual void addDirectory(Folder *) = 0;
	virtual void removeDirectory() = 0;
	virtual void addFile(File *) = 0;
	virtual void removeFile() = 0;
	virtual ~NodeIterator();
};

#endif
