#include <iostream>
#include "Product.h"
#include "ProductStateMemory.h"
#include <string>

int main()
{
    string n, d;
    double cost;
    Product* p; // Originator
    ProductStateMemory careTaker;
	
    cout << "Enter name of product: ";
    getline(cin, n);
    cout << "Enter description: ";
    getline(cin, d);
    cout << "Enter cost: ";
    cin >> cost;
    p = new Product(n,d,cost);
    p->display();
    cin.ignore(100, '\n');
	
    cout << "\nEnter new description : ";
    getline(cin, d);
    p->setDescription(d);
    p->display();

    careTaker.setMemento(p->makeBackup());
    cout << "\n---\nI MADE A BACKUP HERE\n";
    
    cout << "\nEnter new cost : ";
    cin >> cost;
    p->setCost(cost);
    p->display();
    
    cout << "\n---\nRESTORE THE BACKUP\n";
    p->restore(careTaker.getMemento());
    
    p->display();
    return 0;
}
