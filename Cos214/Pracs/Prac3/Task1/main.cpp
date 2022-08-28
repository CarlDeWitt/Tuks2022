#include "ConfectioneryFactory.h"
#include "CadburyFactory.h"
#include "LindtFactory.h"
#include "NestleFactory.h"
#include "Basket.h"
#include <iostream>
#include "string"
#include "Checkout.h"
#include "Hamper.h"

using namespace std;

Confectionery **confextions;
ConfectioneryFactory **factory;
string input;
string input2;
string input3;
int input4;
int i = 0;

void initilize()
{

    factory = new ConfectioneryFactory *[3];
    factory[0] = new CadburyFactory();
    factory[1] = new LindtFactory();
    factory[2] = new NestleFactory();
    confextions = new Confectionery *[20];
}
void showtypes()
{
    cout << "" << endl;
    cout << "|..............MENU.............|" << endl;
    cout << "type one of the following out" << endl;
    cout << "1. Cadbury/c" << endl;
    cout << "2. Lindt/l" << endl;
    cout << "3. Nestle/n" << endl;
    cout << "4. exit/e" << endl;
    cout << "|...............................|" << endl;
    cout << "" << endl;
}

void dealocate()
{
    for (int i = 0; i < 20; i++)
    {
        delete confextions[i];
    }
    for (int i = 0; i < 3; i++)
    {
        delete factory[i];
    }
    delete[] confextions;
    delete[] factory;
}

void run()
{
    if (i >= 20)
    {
        cout << "Sorry, You are getting fat please go for a run" << endl;
        dealocate();
        return;
    }
    showtypes();
    cout << "Enter the type of confectionery you want to create: ";
    cin >> input;
    if (input == "lindt" || input == "l")
    {
        cout << "You have selected Lindt" << endl
             << "Do you want a lint Slab Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {

            confextions[i] = factory[1]->createChocolate(true);
            confextions[i]->getDescription();
        }
        else
        {
            confextions[i] = factory[1]->createChocolate(false);
            confextions[i]->getDescription();
        }
    }
    else if (input == "cadbury" || input == "c")
    {
        cout << "You have selected Cadbury" << endl
             << "Do you want a Aerated chocolate Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {
            cout << "Nice job you have selected Aerated chocolate" << endl
                 << "How much air do you want to add in cm: ";
            cin >> input4;
            confextions[i] = factory[0]->createAeratedChocolate(input4);
            confextions[i]->getDescription();
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                confextions[i] = factory[0]->createChocolate(true);
                confextions[i]->getDescription();
            }
            else
            {
                confextions[i] = factory[0]->createChocolate(false);
                confextions[i]->getDescription();
            }
        }
    }
    else if (input == "nestle" || input == "n")
    {
        cout << "You have selected Nestle" << endl
             << "Do you want a Aerated chocolate Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {
            cout << "Nice job you have selected Aerated chocolate" << endl
                 << "How much air do you want to add in cm: ";
            cin >> input4;
            confextions[i] = factory[2]->createAeratedChocolate(input4);
            confextions[i]->getDescription();
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                confextions[i] = factory[2]->createChocolate(true);
                confextions[i]->getDescription();
            }
            else
            {
                confextions[i] = factory[2]->createChocolate(false);
                confextions[i]->getDescription();
            }
        }
    }
    else if (input == "exit" || input == "e")
    {
        dealocate();
        return;
    }
    else
    {
        cout << "Really bitch that aint it" << endl;
    }
    i++;
    run();
}

Hamper *h;
int priceCount = 0, spinner = 0;
double sum = 0;
void initilizeComp()
{
    string str, str2;
    cout << "Hamper name: ";
    cin >> str;
    cout << "Description of " << str << ": ";
    cin >> str;
    h = new Hamper(str, str2);
}

void printprice()
{
    if (spinner > 20)
    {
        spinner++;
        printprice();
    }
    for (Confectionery *c : h->getChockbox())
    {
        sum += c->getPrice();
    }
    cout << "R: " << sum << endl;
    return;
}

void printHamper()
{
    if (h != NULL)
    {
        cout << "|---------------------------|" << endl;
        cout << "Here is you basket" << endl;
        h->chockInfo();
        cout << "|---------------------------|" << endl;
        cout << "Here is you Price of your basket" << endl;
        printprice();
    }
    return;
}

int n = 0, m = 0;
void runcomposite()
{
    if (m == 0)
    {
        initilizeComp();
        m++;
    }
    if (n >= 20)
    {
        cout << "Sorry, You are getting fat please go for a run" << endl;
        dealocate();
        return;
    }
    showtypes();
    cout << "Enter the type of confectionery you want to create: ";
    cin >> input;
    if (input == "lindt" || input == "l")
    {
        cout << "You have selected Lindt" << endl
             << "Do you want a lint Slab Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {

            h->addItem(confextions[i] = factory[1]->createChocolate(true));
        }
        else
        {
            h->addItem(confextions[i] = factory[1]->createChocolate(false));
        }
    }
    else if (input == "cadbury" || input == "c")
    {
        cout << "You have selected Cadbury" << endl
             << "Do you want a Aerated chocolate Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {
            cout << "Nice job you have selected Aerated chocolate" << endl
                 << "How much air do you want to add in cm: ";
            cin >> input4;
            h->addItem(confextions[i] = factory[0]->createAeratedChocolate(input4));
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                h->addItem(confextions[i] = factory[0]->createChocolate(true));
            }
            else
            {
                h->addItem(confextions[i] = factory[0]->createChocolate(false));
            }
        }
    }
    else if (input == "nestle" || input == "n")
    {
        cout << "You have selected Nestle" << endl
             << "Do you want a Aerated chocolate Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {
            cout << "Nice job you have selected Aerated chocolate" << endl
                 << "How much air do you want to add in cm: ";
            cin >> input4;
            h->addItem(confextions[i] = factory[2]->createAeratedChocolate(input4));
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                h->addItem(confextions[i] = factory[2]->createChocolate(true));
            }
            else
            {
                h->addItem(confextions[i] = factory[2]->createChocolate(false));
            }
        }
    }
    else if (input == "exit" || input == "e")
    {
        printHamper();
        dealocate();
        return;
    }
    else
    {
        cout << "Really bitch that aint it" << endl;
    }
    n++;
    runcomposite();
}

int main()
{
    initilize();
    // Abstract Factory
    // run();

    // Composite
    runcomposite();

    return 0;
}