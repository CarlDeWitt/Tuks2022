#include "FileMacfee.h"
FileMacfee::FileMacfee() {}
void FileMacfee::VirusCheck(Node *n)
{
    if (n->name == "virus.exe" || n->getContent() == "virus")
    {
        cout << "⚠⚠⚠⚠⚠⚠⚠⚠⚠  Virus found  !!!!!!!!!!!!!!!!!" << endl
             << "kindly uninstall you OS and spray cpu with sanitizer" << endl
             << "also put a mask over your gpu fans to stop the spread of the virus" << endl;
    }
    else
    {
        cout << "No virus found" << endl;
    }
}
FileMacfee::~FileMacfee() {}
