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

Confectionery **confextions[1];
ConfectioneryFactory *factory[3];
string input;
string input2;
string input3;
int input4;
int i = 0;

void initilize()
{
    factory[0] = new CadburyFactory();
    factory[1] = new LindtFactory();
    factory[2] = new NestleFactory();
}

void run()
{
    Confectionery *confext1ons;
    cout << "Enter the type of confectionery you want to create: ";
    cin >> input;
    if (input == "lindt" || input == "l")
    {
        cout << "You have selected Lindt" << endl
             << "Do you want a lint Slab Y/N:";
        cin >> input2;
        if (input2 == "Y" || input2 == "y")
        {

            confext1ons = factory[1]->createChocolate(true);
            confext1ons->getDescription();
        }
        else
        {
            confext1ons = factory[1]->createChocolate(false);
            confext1ons->getDescription();
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
            confext1ons = factory[0]->createAeratedChocolate(input4);
            confext1ons->getDescription();
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                confext1ons = factory[0]->createChocolate(true);
                confext1ons->getDescription();
            }
            else
            {
                confext1ons = factory[0]->createChocolate(false);
                confext1ons->getDescription();
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
            confext1ons = factory[2]->createAeratedChocolate(input4);
            confext1ons->getDescription();
        }
        else
        {
            cout << "Nice job you have selected Chocolate" << endl
                 << "Do you want a Slab Y/N:";
            cin >> input3;
            if (input3 == "Y" || input3 == "y")
            {
                confext1ons = factory[2]->createChocolate(true);
                confext1ons->getDescription();
            }
            else
            {
                confext1ons = factory[2]->createChocolate(false);
                confext1ons->getDescription();
            }
        }
    }
    else if (input == "exit" || input == "e")
    {
        return;
    }
    else
    {
        cout << "Really bitch that aint it" << endl;
    }
    run();
}

void runcomposite()
{
    Hamper *h = new Hamper()
}

int main()
{

    runcomposite();

    return 0;
}