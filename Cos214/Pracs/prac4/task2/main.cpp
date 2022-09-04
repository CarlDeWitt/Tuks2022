#include <iostream>
#include "string"
#include "Node.h"
#include "File.h"
#include "HTMLfiles.h"
#include "JAVAfiles.h"
#include "Folder.h"

using namespace std;

int main()
{

    Node *n1 = new Folder("COS226");
    Node *n2 = new Folder("IMY220");
    Node *n3 = new Folder("IMY220 prac");
    Node *n4 = new Folder("IMY220 assignment");

    Node *n5 = new HTMLfiles("IMY220 assignment", "Hello World");
    Node *n6 = new JAVAfiles("COS226 assignment", "Hello World");
    n2->add(n3);

    n3->add(new HTMLfiles("splash", "this is index file"));
    n3->add(new HTMLfiles("about", "this is about file"));

    n2->add(n4);
    n4->add(new HTMLfiles("ass1", "this is index file"));
    n4->add(n5);

    n1->add(new JAVAfiles("main", "This is the main file"));
    n1->add(new HTMLfiles("index", "this is index file"));
    n1->add(n2);

    // n1->list();
    // n5->run();
    n6->run();

    // n6->clearContent();

    delete n1;
    delete n2;
    delete n3;
    delete n4;

    return 0;
}