#ifndef NODE_H
#define NODE_H
#include <chrono>
#include <ctime>
class Node
{

public:
	Node();
	virtual void run() = 0;
	virtual void add(Node *arg) = 0;
	virtual void list() = 0;
	virtual ~Node();
};

#endif
