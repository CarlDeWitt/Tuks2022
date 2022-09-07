#include "HTMLfiles.h"

HTMLfiles::HTMLfiles(string name, string content) : File(name, content, "file")
{
	this->type = ".html";
}

void HTMLfiles::Open()
{
	cout << "Opening Chrome web browser" << endl;
}
void HTMLfiles::Close()
{
	cout << "Closing Chrome web browser" << endl;
}

string HTMLfiles::getType()
{
	return type;
}
// void HTMLfiles::renameFile(string n)
// {
// 	name = n;
// 	notifyAll();
// }

HTMLfiles::~HTMLfiles()
{
}
