#include <iostream>
#include "string"
#include "Node.h"
#include "File.h"
#include "HTMLfiles.h"
#include "JAVAfiles.h"
#include "Folder.h"
#include "NodeIterator.h"
#include "DirectoryIterator.h"
#include "FileIterator.h"

using namespace std;

int main()
{

    Node *n1 = new Folder("Home");
    Node *n2 = new Folder("IMY220");
    Node *n3 = new Folder("IMY220 prac");
    Node *n4 = new Folder("IMY220 assignment");
    Node *n5 = new Folder("COS226");
    Node *n6 = new Folder("COS284");

    n1->add(new HTMLfiles("index", "<p>Hello World</p>"));
    n1->add(new HTMLfiles("about", "<p>About</p>"));

    n3->add(new HTMLfiles("login", "<p>login</p>"));
    n3->add(new HTMLfiles("signup", "<p>signup</p>"));

    n4->add(new HTMLfiles("splash", "<p>Splash</p>"));
    n4->add(new HTMLfiles("home", "<p>Home</p>"));

    n5->add(new JAVAfiles("Main", "public class Main "));
    n5->add(new JAVAfiles("thread", "public class thread "));

    n6->add(new JAVAfiles("asm", "lol get wrecked"));
    n6->add(new JAVAfiles("asm2", "lol get wrecked again"));
    n6->add(new JAVAfiles("asm3", "lol get wrecked again again"));
    n6->add(new JAVAfiles("asm4", "lol get wrecked again again again"));
    n6->add(new JAVAfiles("asm5", "lol get wrecked again again again again"));
    n6->add(new JAVAfiles("asm6", "lol get wrecked again again again again again"));
    n1->add(n2);
    n1->add(n5);
    n1->add(n6);
    n2->add(n3);
    n2->add(n4);

    n2->add(new Folder("COS226 prac"));
    n5->add(new Folder("COS226 prac"));

    NodeIterator *Fodlerit = new DirectoryIterator(n1->getDirectory());
    NodeIterator *fileIT = new FileIterator(n1->getDirectory());
    // // n6->run();
    // it->addDirectory(new Folder("COS226"));
    // // it->removeDirectory();

    while (Fodlerit->hasNext())
    {
        cout << Fodlerit->current()->name << endl;
        Fodlerit->listDirectory();
        // cout << Fodlerit->next() << endl;
        Fodlerit->next();
    }

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    delete n1;
    delete n2;
    delete n3;
    delete n4;
    delete n5;
    delete n6;

    return 0;
}