#pragma once

#include "Macfee.h"

class FileMacfee : public Macfee

{
private:
public:
    FileMacfee();
    void VirusCheck(Node *);
    ~FileMacfee();
};
