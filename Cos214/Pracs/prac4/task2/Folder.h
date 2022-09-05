#ifndef FOLDER_H
#define FOLDER_H
#include "Node.h"
#include <vector>
#include <string>
#include <iostream>
using namespace std;

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
	~Folder();
};

#endif
