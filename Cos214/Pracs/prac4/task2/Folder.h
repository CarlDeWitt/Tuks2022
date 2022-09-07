#ifndef FOLDER_H
#define FOLDER_H
#include "Node.h"
#include <vector>
#include <string>
#include <iostream>
using namespace std;

class Node;

class Folder : public Node
{

private:
	string name;
	long time;
	vector<Node *> directory;

public:
	Folder(string name);
	void add(Node *arg);
	void remove(Node *arg);
	void run();
	void list();
	vector<Node *> getDirectory();
	void setDirectory(vector<Node *>);
	Root *create();
	void notifyAll();
	void rename(string);
	void restrore(Root *r);
	void clear();
	~Folder();
};

#endif
