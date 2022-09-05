#include "JAVAfiles.h"

JAVAfiles::JAVAfiles(string name, string content) : File(name, content, "file")
{
	this->type = ".java";
}

void JAVAfiles::Open()
{
	cout << "Opening the linux terminal" << endl;
}
void JAVAfiles::Close()
{
	cout << "Closing the linux terminal" << endl;
}

string JAVAfiles::getType()
{
	return type;
}

JAVAfiles::~JAVAfiles()
{
}
