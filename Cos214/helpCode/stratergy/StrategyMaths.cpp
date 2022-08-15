#include <iostream>

#include "Context.h"
#include "Calculator.h"

using namespace std;

int  main() {
        Context* context[3];
        
        // Three contexts following different strategies
        context[0] = new Context(new Add());
        int resultA = context[0]->calculate(3,4);

    
        context[1] = new Context(new Subtract());
        int resultB = context[1]->calculate(3,4);
    
    
        context[2] = new Context(new Multiply());
        int resultC = context[2]->calculate(3,4);
    
        cout << "Result A : " << resultA << endl;
        cout << "Result B : " << resultB << endl;
        cout << "Result C : " << resultC << endl;
    
        
    for (int i = 0; i < 3; i++)
        delete context[i];
        
    return 0;
}
