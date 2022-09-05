#include <iostream>
#include "Queue.h"
#include "QueueIterator.h"

// Still need to include a QueueIterator

using namespace std;

int main(){

    Queue<int>* myQueue = new Queue<int>();
        
    myQueue->enqueue(10);
    myQueue->enqueue(20);
    myQueue->enqueue(30);
    myQueue->enqueue(5);
    
    
    while (!myQueue->isEmpty())
        cout<<myQueue->dequeue()<<"\t";
    cout<<endl;
    myQueue->enqueue(10);
    myQueue->enqueue(20);
    myQueue->enqueue(30);
    myQueue->enqueue(5);
    
    myQueue->dequeue();
    myQueue->enqueue(50);
    
    QueueIterator<int> i;
    for (i = myQueue->begin(); !(i == myQueue->end()); ++i)
        cout<<*i<<"\t";
    cout<<*i<<endl;
    return 0;
}
