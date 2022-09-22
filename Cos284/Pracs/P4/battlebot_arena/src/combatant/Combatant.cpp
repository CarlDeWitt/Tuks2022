#include <combatant/Combatant.h>

Combatant::Combatant(string name) {
  this->energy = 100;
  this->name = name;
  this->shield = 0;
  this->score = 0;
}

Combatant::~Combatant() {
}

void Combatant::rechargeBattery() {
  // Uniformly distributed random number between 1 and 20
  random_device rd;
  mt19937 gen(rd());
  uniform_int_distribution<> dis(5, 20);
  int charge = dis(gen);

  if (this->energy == 100) {
    this->score = (this->score - charge < 0) ? 0 : this->score - charge;
    BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + "Battery was already full. " + this->name + " lost " + std::to_string(charge) + " points.");
    return;
  }

  this->energy = (this->energy + charge > 100) ? 100 : this->energy + charge;

  BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " recharged their battery by " + std::to_string(charge) + " points.");
}

void Combatant::activateBarrier(int charge) {
  if (this->energy > charge) {
    this->energy -= charge;
    
    // Using uniform distribution to generate a random value between 0.9 and 1.6
    random_device rd;
    mt19937 gen(rd());
    uniform_real_distribution<> dis(0.9, 1.6);
    double multiplier = dis(gen);
    int increase = charge * multiplier;

    this->shield = this->shield + increase;

    BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " spent " + std::to_string(charge) + " energy and increased their shield by " + std::to_string(increase) + " points.");
    return;
  }

  BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " tried to increase their shield but didn't have enough energy.");
}

int Combatant::receiveDamage(int damage) {
  if (this->shield > 0) {
    int unblockedDamage = (damage - this->shield) > 0 ? (damage - this->shield) : 0;

    if (unblockedDamage == 0) {
      this->score += (BATTLE_ROUND + 3) * damage;
    }

    this->shield = (damage > this->shield) ? 0 : this->shield - damage;
    this->energy -= unblockedDamage;

    return unblockedDamage;
  }

  this->energy -= damage;
  return damage;
}

void Combatant::zapEnergy(Combatant* target, int charge) {

  if (charge == 0) {
    BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " tried to zap " + target->getName() + " but didn't provide enough energy.");
    return;
  }

  if (charge > 30) {
    BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " tried to zap " + target->getName() + " but provided too much energy.");
    this->score = (this->score - charge - 30 < 0) ? 0 : this->score - charge - 30;
    return;
  }
  
  if (this->energy > charge) {
    // Using uniform distribution to generate a random value between 1 and 2
    random_device rd;
    mt19937 gen(rd());
    uniform_real_distribution<> dis(1, 2);
    double multiplier = dis(gen);
    int attack = charge * multiplier;

    // Calculate hit chance. The higher charge, the lower the chance of hitting
    int hitChance = 100 - (charge * 2);

    // Using uniform distribution to generate a random value between 0 and 100
    random_device rd2;
    mt19937 gen2(rd2());
    uniform_real_distribution<> dis2(0, 100);
    int hit = dis2(gen2);

    if (hit > hitChance) {

      BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " tried to zap " + target->getName() + " but missed.");
      return;
    }

    this->energy -= charge;

    int recovery = target->receiveDamage(attack) * 0.5;
    if (recovery > 0) {
      BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " zapped " + target->getName() + " for " + std::to_string(attack) + " points and recovered " + std::to_string(recovery) + " energy.");
    } else {
      BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " zapped " + target->getName() + " for " + std::to_string(attack) + " points but it was blocked.");
    }

    this->score += (BATTLE_ROUND + 3) * recovery;
    this->energy = (this->energy + recovery > 100) ? 100 : this->energy + recovery;

    return;
  }

  BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + this->name + " tried to zap " + target->getName() + " but didn't have enough energy.");
  this->score = (this->score - charge < 0) ? 0 : this->score - charge;
}