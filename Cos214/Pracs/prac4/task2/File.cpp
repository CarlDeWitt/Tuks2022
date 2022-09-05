#include "File.h"

File::File(string name, string content, string type) : Node(type, name)
{
	this->name = name;
	this->content = content;
	this->time = 0;
}

void File::clearContent()
{
	this->content = "";
}

void File::renameFile(string name)
{
	this->name = name;
}

void File::addContent(string content)
{
	this->content += content;
}

void File::run()
{
	this->Open();
	cout << "Running program" << endl;
	cout << this->content << endl;
	this->Close();
}

void File::list()
{
	// cout << this->name << this->getType() << " was created at " << this->time << endl;
	cout << " -" << this->name << this->getType() << endl;
}

void File::add(Node *arg)
{
	cout << "Cannot add a file to a file" << endl;
}

vector<Node *> File::getDirectory()
{
	return vector<Node *>();
}

File::~File()
{
}
