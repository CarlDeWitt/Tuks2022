#include "Subtract.h"

int Subtract::execute(int a, int b) {
        cout << "Called Subtract's execute()" << endl;
        return a - b;  // Do a subtraction with a and b
}

Subtract::~Subtract() {
    cout << " Subtract deleting" << endl;
}