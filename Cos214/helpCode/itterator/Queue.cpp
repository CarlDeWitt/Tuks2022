#ifndef _QUEUE_C
#define _QUEUE_C

    #include "Node.h"
    #include "Queue.h"
    #include "QueueIterator.h"

    template <typename T>
    Queue<T>::Queue(){
        head = 0;
    }
    
    template <typename T>
    void Queue<T>::enqueue(T e){
        Node<T>* n = new Node<T>();
        n->element = e;
        if (isEmpty()) {
            n->next = n;
            n->previous = n;
        } else {
            n->next = head;
            n->previous = head->previous;
            head->previous->next = n;
            head->previous = n;
        }
        head = n;
    }
    
    template <typename T>
    T Queue<T>::dequeue(){
        if (isEmpty())
            return 0;
        else if (head->previous == head) {
            Node<T> *tmp= head;
            head = 0;
            return tmp->element;
        } else {
            Node<T> *tmp = head->previous;
            head->previous = head->previous->previous;
            head->previous->next = head;
            return tmp->element;
        }
    }
    
    template <typename T>
    bool Queue<T>::isEmpty(){
        return head == 0;
    }
    
    template <typename T>
    QueueIterator<T> Queue<T>::begin(){
        return QueueIterator<T> (*this, head);
    }

    template <typename T>
    QueueIterator<T> Queue<T>::end(){
        return QueueIterator<T> (*this, head->previous);
    }
   
#endif
