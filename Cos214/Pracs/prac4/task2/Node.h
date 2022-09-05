#ifndef NODE_H
#define NODE_H
#include <chrono>
#include <ctime>
#include "string"
#include "vector"
using namespace std;
class Node
{
public:
	string type;
	string name;
	Node(string, string);
	virtual void run() = 0;
	virtual void add(Node *arg) = 0;
	virtual void list() = 0;
	virtual ~Node();
	virtual vector<Node *> getDirectory();
};

#endif
