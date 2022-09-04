#ifndef FILE_H
#define FILE_H
#include "Node.h"
#include <string>
#include <ctime>
#include <iostream>
using namespace std;

class File : public Node
{

private:
	string name;
	string content;
	int time;

public:
	File(string name, string content);
	void run();
	void clearContent();
	void renameFile(string name);
	void addContent(string content);
	void list();
	void add(Node *arg);
	virtual void Open() = 0;
	virtual void Close() = 0;
	virtual string getType() = 0;
	virtual ~File();
};

#endif
