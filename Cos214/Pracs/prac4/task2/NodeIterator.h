#ifndef NODEITERATOR_H
#define NODEITERATOR_H

#include "Node.h"
#include "Folder.h"
#include "File.h"

class NodeIterator
{

public:
	NodeIterator();
	virtual Node *first();
	virtual Node *next();
	virtual Node *nextl();
	virtual bool hasNext();
	virtual Node *current();
	virtual bool listDirectory();
	virtual bool isEmpty();
	virtual bool listFile();
	virtual void addDirectory(Folder *);
	virtual void removeDirectory();
	virtual void addFile(File *);
	virtual void removeFile();
	virtual ~NodeIterator();
};

#endif
