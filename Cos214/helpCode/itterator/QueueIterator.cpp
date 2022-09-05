#ifndef _QUEUEITERATOR_C
#define _QUEUEITERATOR_C

  #include <iostream>
  using namespace std;
  #include "QueueIterator.h"
  #include "Queue.h"
  #include "Node.h"
 
  template <typename T>
  QueueIterator<T>::QueueIterator() : head(0), current(0) {}

  template <typename T>
  QueueIterator<T>::QueueIterator(const Queue<T>& source, Node<T>* p) : head(source.head), current(p){}
      
  template <typename T>
  T& QueueIterator<T>::operator*(){
      return current->element;
  }
  
  template<typename T>
  QueueIterator<T> QueueIterator<T>::operator++(){
      if (this != nullptr)
          this->current = this->current->next;
      return *this;
  }
  
  template <typename T>
  bool QueueIterator<T>::operator==(const QueueIterator<T>& rhs) const{
      return current == rhs.current;
  }
  
#endif
