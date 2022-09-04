#ifndef HTMLFILES_H
#define HTMLFILES_H
#include "File.h"

class HTMLfiles : public File
{

public:
	string type;

	HTMLfiles(string name, string content);
	void Open();
	void Close();
	string getType();
	~HTMLfiles();
};

#endif
