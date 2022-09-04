#include "Folder.h"
#include <iterator>

Folder::Folder(string name) : Node()
{
	this->name = name;
	this->time = 0;
	directory = vector<Node *>();
}

void Folder::add(Node *arg)
{
	directory.push_back(arg);
}

void Folder::remove(Node *arg)
{
	throw "Not yet implemented";
}

void Folder::list()
{
	// cout << "-----Folder " << name << "-----" << endl;
	// cout << "---------------------" << endl;
	cout << name << endl;

	// vector<Node *>::iterator it = directory.begin();

	// while ((*it) != NULL)
	// {

	// 	(*it)->list();
	// 	it++;
	// }

	for (int i = 0; i < directory.size(); i++)
	{
		directory[i]->list();
	}
}

void Folder::run()
{
	throw "Folder cant run";
}

Folder::~Folder()
{
}
