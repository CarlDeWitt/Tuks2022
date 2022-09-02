#include <iostream>

using namespace std;

int improve(int, int);

int main()
{
    int mark = 59, highest = 87;
    cout << improve(mark, highest);
    mark = -2;
    highest = 0;
    cout << improve(mark, highest);
    return 0;
}

int improve(int a, int b)
{
    return ((double)(a / b)) * 100;
}