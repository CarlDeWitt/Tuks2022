#include "Pokemon.h"
#include "PlayStyle.h"
#include "PhysicalAttackPlayStyle.h"
#include "AttackPlayStyle.h"
#include "RunPlayStyle.h"
#include <iostream>
#include "string"
using namespace std;

Pokemon *p1;
Pokemon *p2;
bool turn = true;
string input;
PlayStyle *p;

PlayStyle *style()
{
    string str;
    cout << "For Runnable style press r" << endl;
    cout << "For Physical style press p" << endl;
    cout << "For Attack Style press s" << endl;
    cin >> str;

    if (str == "r")
    {
        return new RunPlayStyle();
    }
    else if (str == "p")
    {
        return new PhysicalAttackPlayStyle();
    }
    else if (str == "s")
    {
        return new AttackPlayStyle();
    }
    else
        return NULL;
}

void makegame()
{
    string name;
    int dam, hp;
    cout << "Please enter your Pokimons name" << endl;
    cin >> name;
    cout << "Enter the damage" << endl;
    cin >> dam;
    cout << "Enter the HP" << endl;
    cin >> hp;
    p = style();
    p1 = new Pokemon(name, hp, dam, p);
    cout << "------------------------" << endl;

    cout << "Please enter your Enemy Pokimons name" << endl;
    cin >> name;
    cout << "Enter the damage" << endl;
    cin >> dam;
    cout << "Enter the HP" << endl;
    cin >> hp;
    p = style();
    p2 = new Pokemon(name, hp, dam, p);
}

void welcomeMSG()
{
    cout << "Welcome to poki brawl Here are instructions" << endl;
    cout << "-------------------------------------------" << endl;
    cout << "press 1 to attack" << endl;
    cout << "press 2 to change state" << endl;
    cout << "press 3 to change style" << endl;
    cout << "press 4 to exit" << endl;
    cout << "Enjoy the game" << endl;
    cout << "-------------------------------------------" << endl;
    makegame();
}

void play()
{
    if (turn)
    {
        turn = false;
        cout << "------------------------" << endl;
        cout << "Player 1's turn" << endl;
        cout << "Enter you next move Cowboy" << endl;
        cin >> input;
        if (input == "1")
        {
            p2->takeDamage(p1->attack());
        }
        else if (input == "2")
        {
            string s;
            cout << "Enter the new state" << endl;
            cout << "options: agile/normal/strong" << endl;
            cin >> s;
            p1->selectBattleState(s);
            turn = true;
            play();
        }
        else if (input == "3")
        {
            string s;
            cout << "Enter the new style" << endl;
            cout << "options: r->Run/p->Physical/s->Strenght" << endl;
            cin >> s;
            p1->setStyle(s);
            turn = true;
            play();
        }
        else if (input == "4")
        {
            cout << "Thanks for playing" << endl;
            return;
        }
        else
        {
            cout << "Invalid input" << endl;
        }
    }
    else
    {
        turn = true;
        cout << "------------------------" << endl;
        cout << "Player 2's turn" << endl;
        cout << "Enter you next move Cowboy" << endl;
        cin >> input;
        if (input == "1")
        {
            p1->takeDamage(p2->attack());
        }
        else if (input == "2")
        {
            string s;
            cout << "Enter the new state" << endl;
            cout << "options: agile/normal/strong" << endl;
            cin >> s;
            p2->selectBattleState(s);
            turn = false;
            play();
        }
        else if (input == "3")
        {
            string s;
            cout << "Enter the new style" << endl;
            cout << "options: r->Run/p->Physical/s->Strenght" << endl;
            cin >> s;
            p2->setStyle(s);
            turn = false;
            play();
        }
        else if (input == "4")
        {
            cout << "Thanks for playing" << endl;
            return;
        }
        else
        {
            cout << "Invalid input" << endl;
        }
    }
    play();
}

main()
{
    // Pokemon *p1 = new Pokemon("Pikachu", 100, 20, new PhysicalAttackPlayStyle());
    // p1->attack();
    // p1->setStyle("r");
    // p1->attack();
    welcomeMSG();
    play();
    return 0;
}