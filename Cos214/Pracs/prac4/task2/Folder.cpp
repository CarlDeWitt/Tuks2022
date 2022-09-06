#include "Folder.h"
#include <iterator>

Folder::Folder(string name) : Node("folder", name)
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

	// vector<Node *>::iterator it = this->directory.begin();

	// while ((*it) != *this->directory.end())
	// {
	// 	// if ((*it)->type == "folder")
	// 	// {
	// 	// 	(*it)->list();
	// 	// }

	// 	(*it)->list();
	// 	// if ((*it) != *directory.end())
	// 	// {
	// 	// 	it++;
	// 	// }
	// 	it++;
	// }
	// if (this->type == "folder")
	// {
	// 	cout << " -" << this->name << endl;
	// }

	for (int i = 0; i < this->directory.size(); i++)
	{
		if (this->directory[i]->type == "folder")
		{
			cout << " /" << directory[i]->name << endl;
		}
	}
}

void Folder::run()
{
	cout << "Folder cant run" << endl;
}

vector<Node *> Folder::getDirectory()
{
	return directory;
}

void Folder::setDirectory(vector<Node *> direc)
{
	this->directory = direc;
}
Root *Folder::create()
{
	return new Root(getDirectory());
}
void Folder::restrore(Root *r)
{
	this->directory = r->getState();
}
void Folder::clear()
{
	// r->clear();
}

Folder::~Folder()
{
}
