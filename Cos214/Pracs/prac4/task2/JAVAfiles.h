#ifndef JAVAFILES_H
#define JAVAFILES_H
#include "File.h"

class JAVAfiles : public File
{

public:
	string type;

	JAVAfiles(string name, string content);

	void Open();
	void Close();
	string getType();
	~JAVAfiles();
};

#endif
