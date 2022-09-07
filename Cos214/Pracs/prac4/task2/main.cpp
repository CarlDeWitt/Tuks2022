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
#include "Root.h"
#include "Caretaker.h"
#include <vector>
using namespace std;

vector<Node *> nodes;
Node *cur;
Caretaker *caretaker = new Caretaker();
int dirCount = 0, fileCount = 0;

void list();
void addFile();
void addFolder();
void bk();
void rt();
void cd();
void dir();
void file();

void createHome()
{
    string name;
    cout << "Hello there plz create your home directory" << endl;
    cin >> name;
    Node *home = new Folder(name);
    nodes.push_back(home);
    cur = home;
}
void printoptions()
{
    cout << endl
         << "-------MENU-------" << endl;
    cout << "ls: to list all directory" << endl;
    cout << "afile: to add a file" << endl;
    cout << "adir: to add a folder" << endl;
    cout << "cd: to choose current directory" << endl;
    cout << "bk: to save current directory" << endl;
    cout << "rt: to restore current directory" << endl;
    cout << "file: to interact with file" << endl;
    cout << "dir: to interact with directory" << endl;
    cout << "ex: to exit" << endl
         << endl;
}

int choice(string inpt)
{
    if (inpt == "ls")
    {
        cout << "-------listing-------" << endl;
        list();
    }
    else if (inpt == "mn" || inpt == "help")
    {
        printoptions();
    }
    else if (inpt == "afile")
    {
        cout << "-------Create file-------" << endl;
        addFile();
    }
    else if (inpt == "adir")
    {
        cout << "-------creating a file-------" << endl;
        addFolder();
    }
    else if (inpt == "cd")
    {
        cout << "-------change directory-------" << endl;
        cd();
    }
    else if (inpt == "bk")
    {
        cout << "-------backup-------" << endl;
        bk();
    }
    else if (inpt == "rt")
    {
        cout << "-------restore-------" << endl;
        rt();
    }
    else if (inpt == "file")
    {
        fileCount = 0;
        file();
    }
    else if (inpt == "dir")
    {
        dirCount = 0;
        dir();
    }
    else if (inpt == "ex")
    {
        cout << "-------exit-------" << endl;

        return -1;
    }
    return 0;
}

void program()
{
    if (nodes.size() == 0)
    {
        createHome();
    }
    // printoptions();
    string input;
    cout << "\033[32mroot@LAPTOP-58ND6B0H:/mnt/c/Users/" << cur->name << "\033[0m ";
    cin >> input;
    int i = choice(input);
    if (i == -1)
    {
        return;
    }
    program();
}

int main()
{

    Node *n1 = new Folder("Home");
    Node *n2 = new Folder("IMY220");
    Node *n3 = new Folder("IMY220 prac");
    Node *n4 = new Folder("IMY220 assignment");
    Node *n5 = new Folder("COS226");
    Node *n6 = new Folder("COS284");

    n2->add(n3);
    n2->add(n4);
    n1->add(n2);
    n1->add(n5);
    n1->add(n6);
    n1->add(new HTMLfiles("index", "<p>Hello World</p>"));
    n1->add(new HTMLfiles("about", "<p>About</p>"));

    nodes.push_back(n1);
    nodes.push_back(n2);
    nodes.push_back(n3);
    nodes.push_back(n4);
    nodes.push_back(n5);
    nodes.push_back(n6);

    cur = n1;

    program();

    // n3->add(new HTMLfiles("login", "<p>login</p>"));
    // n3->add(new HTMLfiles("signup", "<p>signup</p>"));

    // n4->add(new HTMLfiles("splash", "<p>Splash</p>"));
    // n4->add(new HTMLfiles("home", "<p>Home</p>"));

    // n5->add(new JAVAfiles("Main", "public class Main "));
    // n5->add(new JAVAfiles("thread", "public class thread "));

    // n6->add(new JAVAfiles("asm", "lol get wrecked"));
    // n6->add(new JAVAfiles("asm2", "lol get wrecked again"));
    // n6->add(new JAVAfiles("asm3", "lol get wrecked again again"));
    // n6->add(new JAVAfiles("asm4", "lol get wrecked again again again"));
    // n6->add(new JAVAfiles("asm5", "lol get wrecked again again again again"));
    // n6->add(new JAVAfiles("asm6", "lol get wrecked again again again again again"));
    // n1->add(n2);
    // n1->add(n5);
    // n1->add(n6);
    // n2->add(n3);
    // n2->add(n4);

    // n2->add(new Folder("COS226 prac"));
    // n5->add(new Folder("COS226 prac"));

    // NodeIterator *Fodlerit = new DirectoryIterator(cur->getDirectory());
    // NodeIterator *fileIT = new FileIterator(cur->getDirectory());
    // n6->run();
    // Fodlerit->addDirectory(new Folder("COS226"));
    // it->removeDirectory();

    // while (Fodlerit->hasNext())
    // {
    //     cout << Fodlerit->current()->name << endl;
    //     Fodlerit->listDirectory();
    //     // cout << Fodlerit->next() << endl;
    //     Fodlerit->next();
    // }

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     // fileIT->listDirectory();
    //     // cout << fileIT->next() << endl;
    //     fileIT->next();
    // }

    /*memento*/
    // Caretaker *caretaker = new Caretaker();

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    // caretaker->doo(n1->create());

    // n1->add(new JAVAfiles("asm6", "lol get wrecked again again again again again"));

    // cout << "" << endl;
    // fileIT = new FileIterator(n1->getDirectory());

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    // caretaker->doo(n1->create());

    // n1->add(new JAVAfiles("asm420", "lol get wrecked again again again again again"));

    // cout << "" << endl;
    // fileIT = new FileIterator(n1->getDirectory());

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    // n1->restrore(caretaker->undo());
    // cout << "" << endl;

    // fileIT = new FileIterator(n1->getDirectory());

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    // n1->restrore(caretaker->undo());
    // cout << "" << endl;

    // fileIT = new FileIterator(n1->getDirectory());

    // while (fileIT->hasNext())
    // {
    //     fileIT->current()->list();
    //     fileIT->next();
    // }

    // delete n1;
    // delete n2;
    // delete n3;
    // delete n4;
    // delete n5;
    // delete n6;
    return 0;
}

void list()
{
    for (int i = 0; i < nodes.size(); i++)
    {
        if (nodes[i]->type == "folder")
        {
            cout << "Index: " << i << " holds \033[31mDIR \033[0m " << nodes[i]->name << endl;
        }
        else
        {
            cout << "Index: " << i << " holds \033[31mFILE\033[0m " << nodes[i]->name << endl;
        }
    }
}

void addFile()
{
    string name;
    string content;
    string type;
    cout << "Enter file name: ";
    cin >> name;
    cout << "Enter file content: ";
    cin >> content;
    cout << "Enter file type: ";
    cin >> type;
    if (type == "html")
    {
        Node *n = new HTMLfiles(name, content);
        cur->add(n);
        nodes.push_back(n);
    }
    else if (type == "java")
    {
        Node *n = (new JAVAfiles(name, content));
        cur->add(n);
        nodes.push_back(n);
    }
    else
    {
        addFile();
    }
}

void addFolder()
{
    string inpt = "temp";
    cout << "Enter name of folder: ";
    cin >> inpt;
    Node *n = new Folder(inpt);
    cur->add(n);
    nodes.push_back(n);
}

void bk()
{
    cout << "making a backup of: " << cur->name << endl;
    caretaker->doo(cur->create());
    cout << "\033[33mbackup made\033[0m" << endl;
}

void rt()
{
    cout << "restoring backup of: " << cur->name << endl;
    cur->restrore(caretaker->undo());
    cout << "\033[33mbackup restored\033[0m" << endl;
}

void cd()
{
    int inpt;
    cout << "Enter index of folder to go to: ";
    cin >> inpt;
    if (nodes[inpt]->type == "folder")
    {
        cur = nodes[inpt];
    }
    else
    {
        cout << "not a folder" << endl;
        cd();
    }

    cout << "\033[33mcurrent DIR is: " << cur->name << "\033[0m" << endl;
}

void dirMenu()
{
    cout << "-------DIR MENU-------" << endl;
    cout << "lsd:   to list folder under current DIR" << endl;
    cout << "lsa:   to list all DIR's" << endl;
    cout << "adir:  to add a DIR" << endl;
    cout << "adirc: to add a DIR to current DIR" << endl;
    cout << "n:     move to next directory" << endl;
    cout << "rm:    remove DIR" << endl;
    cout << "rnm:   rename DIR" << endl;
    cout << "nm:    DIR name" << endl;
    cout << "ex:    to exit DIR menu" << endl;
}

DirectoryIterator *dit;
void dir()
{
    if (dirCount == 0)
    {
        dit = new DirectoryIterator(cur->getDirectory());
        dirCount++;
    }
    cout << "\033[33mDIR mode root@LAPTOP-58ND6B0H:/mnt/c/Users/" << dit->current()->name << "\033[0m ";
    string inpt;
    cin >> inpt;
    if (inpt == "lsd")
    {
        dit->listDirectory();
    }
    else if (inpt == "lsa")
    {
        // cout << dit.size() << endl;
        while (dit->hasNext())
        {

            cout << dit->current()->name << endl;
            dit->listDirectory();
            // cout << dit->next() << endl;

            dit->next();
        }
    }
    else if (inpt == "adir")
    {
        string inpt2 = "temp";
        cout << "Enter name of folder: ";
        cin >> inpt2;
        dit->addDirectory(new Folder(inpt2));
    }
    else if (inpt == "adirc")
    {
        string inpt2 = "temp";
        cout << "Enter name of folder: ";
        cin >> inpt2;
        dit->current()->add(new Folder(inpt2));
    }
    else if (inpt == "n")
    {
        // dit->hasNext();
        dit->nextl();
        // cout << "\033[36m CURRENT DIR => " << dit->current()->name << "\033[0m" << endl;
    }
    else if (inpt == "rm")
    {
        dit->removeDirectory();
    }
    else if (inpt == "rnm")
    {
        string inpt2 = "temp";
        cout << "Enter new name of folder: ";
        cin >> inpt2;
        dit->current()->rename(inpt2);
    }
    else if (inpt == "nm")
    {
        cout << dit->current()->name << endl;
    }
    else if (inpt == "ex")
    {
        cout << "\033[31mexiting DIR menu\033[0m" << endl;
        return;
    }
    else if (inpt == "help" || inpt == "mn")
    {
        dirMenu();
    }
    dir();
}

void fileMenu()
{
    cout << "-------FILE MENU-------" << endl;
    cout << "lsf:   to list files under current DIR" << endl;
    cout << "adf:  to add a file" << endl;
    cout << "n:    move to next file" << endl;
    cout << "rm:   remove file" << endl;
    cout << "rnm:  rename file" << endl;
    cout << "nm:   file name" << endl;
    cout << "ex:   to exit FILE menu" << endl;
}
NodeIterator *fileIT;
void file()
{
    if (fileCount = 0)
    {
        fileIT = new FileIterator(cur->getDirectory());
        fileCount++;
    }

    cout << "\033[35mFILE mode root@LAPTOP-58ND6B0H:/mnt/c/Users/" << cur->name << "\033[0m ";
    string inpt;
    cin >> inpt;
    if (inpt == "lsf")
    {
        while (fileIT->hasNext())
        {
            fileIT->current()->list();
            fileIT->next();
        }
    }
    else if (inpt == "adf")
    {
        string inpt2 = "temp", inpt3, inpt4;
        cout << "Enter name of file: ";
        cin >> inpt2;
        cout << "Enter file content: ";
        cin >> inpt3;
        cout << "Enter file type: ";
        cin >> inpt4;
        Node *n;
        if (inpt4 == "html")
        {
            n = new HTMLfiles(inpt2, inpt3);
        }
        else
        {
            n = new JAVAfiles(inpt2, inpt3);
        }
        cur->add(n);
    }
    else if (inpt == "n")
    {
        fileIT->nextl();
    }
    else if (inpt == "rm")
    {
        fileIT->removeFile();
    }
    else if (inpt == "rnm")
    {
        string inpt2 = "temp";
        cout << "Enter new name of file: ";
        cin >> inpt2;
        fileIT->current()->rename(inpt2);
    }
    else if (inpt == "nm")
    {
        cout << fileIT->current()->name << endl;
    }
    else if (inpt == "ex")
    {
        cout << "\033[31mexiting FILE menu\033[0m" << endl;
        return;
    }
    else if (inpt == "help" || inpt == "mn")
    {
        fileMenu();
    }
    file();
}
