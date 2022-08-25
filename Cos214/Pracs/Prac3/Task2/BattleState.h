#pragma once

// #include 'class.h'
#include <string>
using namespace std;
#include <iostream>

class BattleState
{

protected:
    string battlestate;

public:
    BattleState();
    virtual int handle(string, int) = 0;
    string getBattleState();
    virtual ~BattleState();
};
