#ifndef NODE_H
#define NODE_H
#include <chrono>
#include <ctime>
#include "string"
#include "vector"
#include "Root.h"
using namespace std;
class Root;

class Node
{
private:
public:
	string type;
	string name;
	Node(string, string);
	virtual void run() = 0;
	virtual void add(Node *arg) = 0;
	virtual void list() = 0;
	virtual ~Node();
	virtual vector<Node *> getDirectory();
	virtual void setDirectory(vector<Node *>);
	virtual Root *create();
	virtual void restrore(Root *r);
	virtual void clear();
};

#endif
