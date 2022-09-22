#ifndef NODE_H
#define NODE_H
#include <chrono>
#include <ctime>
#include "string"
#include "vector"
#include "Root.h"
#include "Macfee.h"
using namespace std;
class Root;
class Macfee;

class Node
{
private:
public:
	Macfee *macfeeptr;
	string type;
	string name;
	Node(string, string);
	void setMacfee(Macfee *);
	virtual void run() = 0;
	virtual void add(Node *arg) = 0;
	virtual void list() = 0;
	virtual void notifyAll() = 0;
	virtual void rename(string) = 0;
	virtual string getContent();
	virtual ~Node();
	virtual vector<Node *> getDirectory();
	virtual void setDirectory(vector<Node *>);
	virtual Root *create();
	virtual void restrore(Root *r);
	virtual void clear();
};

#endif
