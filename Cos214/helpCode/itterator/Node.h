#ifndef _NODE_H
#define _NODE_H
    template <typename T>
    class Node {
        public:
            T element;
            Node *next;
            Node *previous;
    };

#endif
