#include <iostream>
#include "string"
#include "AdventureIsland.h"
#include "SquadMember.h"

using namespace std;

int m =0;
int enemycount = 0;
string input;
AdventureIsland *island = new AdventureIsland();
SquadMember *mem;


void run1()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * @param numOfEnemies
     * @vars Island *island
     *
     */

    island->makesquad("Carl", 50, 5);
    island->playgame(4);
    delete island;
}

void run2()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */

    island->makesquad("Carl", 30, 10);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    delete island;
}

void run3()
{
    /**
     * @brief this game will be played and the squad member will attack all 2 enemies 4 times the enemies will defeat the character if there is no memento being applied
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */

    island->makesquad("Carl", 30, 10);
    island->playgame(2);
    island->playgame(2);
    island->playgame(2);
    island->playgame(2);
    delete island;
}
void run4()
{
    /**
     * @brief this game will be played and the squad member will attack all 4 enemies
     * the squad member wiol take damage but the store will save the state of the squad member and restore it later thus the squad member will be restrored to hs original health
     * @param numOfEnemies
     * @vars Island *island
     *
     */

    island->makesquad("Carl", 30, 10);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    island->saveSquadMember();
    island->playgame(2);
    island->restoreSquad();
    island->playgame(2);
    delete island;
}

void printWlcm(){
    string msg = "Welcome to Adventure Island";
    cout << msg << endl;
}

void printops(){
    string msg2 = "To attack press 1";
    string msg3 = "To store you progress press 2";
    string msg4 = "To restore your progress press 3";
     string msg5 = "To end your game press 4";
    cout << endl << msg2 << endl << msg3 << endl << msg4 << endl << msg5 << endl;
}

void runDynamic(){
    if(m == 0){
        string name;
        int damage, health;
        bool b1 = true, b2 = true;
        cout << "Enter your name" << endl;
        cin >> name;
        while(b1){
            cout << "Enter your damage" << endl;
            cin >> damage;
            if(damage > 0){
                
                b1 = false;
            }else{
                cout << "Enter a number above 0" << endl;
            }
        }
        while(b2){
        cout << "Enter your health" << endl;
        cin >> health;
         if(health > 0){
                
                b2 = false;
            }else{
                cout << "Enter a number above 0" << endl;
            }
        }
        island->makesquad(name, health, damage);
        m++;
        printWlcm();
    }
    // if(!mem->isAlive()){
    //     return;
    // }
    printops();
    cout << "Enter you next move=> ";
    cin >> input;

    if(input == "1"){
        int enemycount;
        cout << "How many enemies do you want to attack?" << endl;
        cin >> enemycount;
        island->playgame(enemycount);
        runDynamic();
    }
    else if(input == "2"){
        cout << "You have saved your progress" << endl;
        island->saveSquadMember();
        runDynamic();
    }
    else if(input == "3"){
        cout << "You have restored your progress" << endl;
        island->restoreSquad();
        runDynamic();
    }
    else if(input == "4"){
        cout << "You have ended your game" << endl;
        return;
    }
    else{
        cout << "Invalid input" << endl;
        runDynamic();
    }
    
}

int main()
{
    runDynamic();
    // run1();
    // run2();
    // run3();
    // run4();

    return 0;
}