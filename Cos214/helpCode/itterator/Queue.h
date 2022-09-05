#ifndef _QUEUE_H
#define _QUEUE_H

    #include "Node.h"
    #include "QueueIterator.h"
    
    template <typename T>
    class Queue{
        friend class QueueIterator<T>;
        public:
            Queue();
            void enqueue(T e);
            T dequeue();
            bool isEmpty();
            QueueIterator<T> begin();
            QueueIterator<T> end();
        private:
            Node<T>* head;
    };

    #include "Queue.cpp"
    
#endif
