#ifndef PLAYSTYLE_H
#define PLAYSTYLE_H
#include <string>
using namespace std;

class PlayStyle
{

public:
	PlayStyle();
	virtual string attack() = 0;
};

#endif
