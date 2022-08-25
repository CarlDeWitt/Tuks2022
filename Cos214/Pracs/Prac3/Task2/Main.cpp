#include "Pokemon.h"
#include <iostream>
#include "string"
using namespace std;

int main()
{
    Pokemon *p1 = new Pokemon("Pikachu", 100, 20);
    p1->selectBattleState("strong");
    return 0;
}