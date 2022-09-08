#include <iostream>
#include <string>
#include <vector>

using namespace std;

class RacingCar
{
public:
    RacingCar(string);
    int fuelReport();
    bool tyreReport(int);
    string carName();
    void go();

private:
    int tyrePressure[4];
    bool tyreTread[4];
    double fuelLevel;
    double fueltankCapacity;
    string name;
};

class PitCrew;

class PitStop
{ // Subject
public:
    bool attach(PitCrew *); // register
    bool detach(PitCrew *); // deregister
    void notify();
    virtual bool tyre(int, int) = 0;
    virtual double fuel(int) = 0;
    virtual bool setCar(RacingCar *) = 0;
    virtual void race() = 0;

private:
    vector<PitCrew *> pitcrew;
};

// An observer
class PitCrew
{
public:
    PitCrew() : car(1), workFor(0), status(0){};
    void registerForWork(PitStop *);
    void setCar(int);
    virtual void update() = 0;
    // need to refuel and change tyres
protected:
    PitStop *workFor;
    int car;
    bool status;
};

bool PitStop::attach(PitCrew *person)
{
    pitcrew.push_back(person);
    person->registerForWork(this);
    return true;
};

bool PitStop::detach(PitCrew *person)
{
    bool found = false;

    vector<PitCrew *>::iterator it = pitcrew.begin();
    while ((it != pitcrew.end()) && (!found))
    {
        if (*it == person)
        {
            found = true;
            pitcrew.erase(it);
        }
        ++it;
    }
    return found;
}

void PitStop::notify()
{
    vector<PitCrew *>::iterator it = pitcrew.begin();
    for (it = pitcrew.begin(); it != pitcrew.end(); ++it)
    {
        (*it)->update();
    }
}

// Helper function
void printWorkshopStatus(PitStop *p)
{
    cout << "Fuel for car 1 = " << p->fuel(1) << endl;
    for (int i = 1; i <= 4; i++)
    {
        cout << "Tyre for car 1, tyre " << i << " = " << p->tyre(1, i) << endl;
    }

    cout << "Fuel for car 2 = " << p->fuel(2) << endl;
    for (int i = 1; i <= 4; i++)
    {
        cout << "Tyre for car 2, tyre " << i << " = " << p->tyre(2, i) << endl;
    }
}

class FerrariStop : public PitStop
{ // concrete subject
public:
    bool tyre(int, int);
    double fuel(int);
    bool setCar(RacingCar *);
    void race();

private:
    RacingCar *cars[2];
};

bool FerrariStop::tyre(int car, int tyre)
{ // Need some error checking here
    return cars[car - 1]->tyreReport(tyre - 1);
}

double FerrariStop::fuel(int car)
{ // Need some error checking here
    return cars[car - 1]->fuelReport();
}

bool FerrariStop::setCar(RacingCar *car)
{
    static int carId = 0;
    if (carId < 2)
    {
        cars[carId] = car;
        carId++;
        return true;
    }
    return false;
}

void FerrariStop::race()
{
    int input;
    cout << "Type in a number [0 stops]:";
    cin >> input;
    while (input != 0)
    {
        if ((input % 2) == 0)
        {
            cars[0]->go();
        }
        else
        {
            cars[1]->go();
        }
        printWorkshopStatus(this);
        notify();
        cout << "Type in a number [0 stops]";
        cin >> input;
    }
}

void PitCrew::registerForWork(PitStop *employer)
{
    workFor = employer;
}

void PitCrew::setCar(int c)
{
    car = c;
}

// Concrete observer1
class TyreChanger : public PitCrew
{
public:
    virtual void update();
};

void TyreChanger::update()
{
    cout << "Tyre changer for car " << car << " status is " << status << endl;
    if (status == 0)
    {
        cout << "Check tyre status" << endl;
        bool tyreStatus = false;
        for (int i = 1; i <= 4; i++)
            tyreStatus = tyreStatus && workFor->tyre(car, i);
        if (tyreStatus)
        {
            status = 1;
            cout << "Need to change all tyres" << endl;
        }
    }
    else
        status = 0;
}

// Concrete observer2
class Refueller : public PitCrew
{
public:
    virtual void update();
};

void Refueller::update()
{
    cout << "Refeuller for car " << car << " status is " << status << endl;
    if (status == 0)
    {
        cout << "Check fuel status" << endl;
        double fuelStatus = workFor->fuel(car);
        cout << "  fuel status is: " << fuelStatus << endl;
        if (fuelStatus < 20)
        {
            status = 1;
            cout << "Need to add fuel" << endl;
        }
    }
    else
        status = 0;
}

RacingCar::RacingCar(string n) : name(n)
{
    for (int i = 0; i < 4; i++)
    {
        tyrePressure[i] = 4;
        tyreTread[i] = true;
    }
    fueltankCapacity = 100;
    fuelLevel = 100;
}

int RacingCar::fuelReport()
{
    return fuelLevel / fueltankCapacity * 100;
}

bool RacingCar::tyreReport(int tyre)
{
    return tyrePressure[tyre] && tyreTread[tyre];
}

string RacingCar::carName()
{
    return name;
}

void RacingCar::go()
{
    int input;
    cout << "Type in any value: " << endl;
    cin >> input;
    if ((input % 2) == 0)
    {
        // Do the tyres
        if ((input % 3) == 0)
        {
            tyreTread[input % 4] = false;
        }
        else
        {
            tyrePressure[input % 4] = false;
        }
    }
    else
    {
        // Do the fuel
        fuelLevel -= 10;
    }
}

int main()
{

    RacingCar *car[2];
    car[0] = new RacingCar("Ferrari One");
    car[1] = new RacingCar("Ferrari Two");

    PitStop *ferrariWorkshop = new FerrariStop();
    //  FerrariStop* ferrariWorkshop = new FerrariStop();

    ferrariWorkshop->setCar(car[0]);
    ferrariWorkshop->setCar(car[1]);

    printWorkshopStatus(ferrariWorkshop);

    /*
      for (int i = 0; i < 10; i++) {
        car[0]->go();

        printWorkshopStatus(ferrariWorkshop);
      }
    */

    PitCrew *refueller = new Refueller();
    refueller->setCar(2);
    ferrariWorkshop->attach(refueller);

    PitCrew *tyreMech = new TyreChanger();
    ferrariWorkshop->attach(tyreMech);

    ferrariWorkshop->race();

    return 0;
}