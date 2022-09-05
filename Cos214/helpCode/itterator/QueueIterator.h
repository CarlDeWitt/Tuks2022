#ifndef _QUEUEITERATOR_H
#define _QUEUEITERATOR_H

//  #include "Node.h"
//  #include "Queue.h"
  template <typename T>
  class Queue;
      
  template <typename T>
  class Node;
      
  template <typename T>
  class QueueIterator {
    friend class Queue<T>;
    public:
      QueueIterator();
      T& operator*();
      QueueIterator<T> operator++();
      bool operator==(const QueueIterator<T>&) const;
    protected:
      QueueIterator(const Queue<T>&, Node<T>*);  
      Node<T>* head;
      Node<T>* current;
  };
  
  #include "QueueIterator.cpp"
  
 #endif
