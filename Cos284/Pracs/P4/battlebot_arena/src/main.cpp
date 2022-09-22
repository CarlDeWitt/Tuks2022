#include <iostream>
#include <string>
#include <random>
#include <unistd.h>

#include <combatant/Combatant.h>
#include <cpp-terminal/constants.hpp>
#include <cpp-terminal/render.h>

std::string CANVAS[23][102] = {
    {"┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┬", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", "E", "N", "E", "R", "G", "Y", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", "_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│", "E", "N", "E", "R", "G", "Y", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "[", " ", "]", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", "(", "\\", " ", " ", " ", " ", "|", "@", "@", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "(", " ", " ", " ", ")", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "(", "_", "_", "/", "\\", "_", "_", " ", "\\", "-", "-", "/", " ", "_", "_", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", ">", "|", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", "S", "H", "I", "E", "L", "D", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", "_", "_", "_", "|", "-", "-", "-", "-", "|", " ", " ", "|", " ", " ", " ", "_", "_", " ", " ", "│", "S", "H", "I", "E", "L", "D", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", "_", "/", "=", "=", "=", "\\", "_", "_", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", " ", "}", "{", " ", "/", "\\", " ", ")", "_", " ", "/", " ", "_", "\\", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "/", "/", "|", " ", "o", "=", "o", " ", "|", "\\", "\\", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "/", "\\", "_", "_", "/", "\\", " ", "\\", "_", "_", "O", " ", "(", "_", "_", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "<", "]", " ", " ", "|", " ", "o", "=", "o", " ", "|", " ", " ", "[", ">", " ", " ", "│"},
    {"│", "S", "C", "O", "R", "E", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "(", "-", "-", "/", "\\", "-", "-", ")", " ", " ", " ", " ", "\\", "_", "_", "/", " ", "│", "S", "C", "O", "R", "E", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", "=", "=", "=", "=", "=", "/", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", ")", "(", " ", " ", ")", "(", "_", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "/", " ", "/", " ", "|", " ", "\\", " ", "\\", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", "-", "-", "-", "|", "|", "-", "-", "-", "/", " ", " ", " ", " ", " ", " ", " ", " ", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "<", "_", "_", "_", "_", "_", "_", "_", "_", "_", ">", " ", " ", " ", " ", "│"},
    {"├", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┴", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┤"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "B", "a", "t", "t", "l", "e", " ", "N", "o", "t", "e", "s", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
    {"└", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┘"}};

std::list<std::string> BATTLE_LOG = {};

int BATTLE_ROUND = 0;
int BATTLE_TURN = 0;

extern "C"
{
  // External Assembly Functions
  void player_turn(
      int myEnergy,    // 0
      int myShield,    // 4
      int theirEnergy, // 8
      int theirShield, // 12
      Combatant *me,   // 20
      Combatant *them, // 28
      int BATTLE_ROUND,
      int BATTLE_TURN);

  // CPP functions that need to be called in Assembly
  void attack(Combatant *attacker, Combatant *defender, int charge)
  {
    attacker->zapEnergy(defender, charge);
  }

  void defend(Combatant *defender, int charge)
  {
    defender->activateBarrier(charge);
  }

  void recharge(Combatant *c)
  {
    c->rechargeBattery();
  }
}

void dummy_strategy(int myEnergy, int myShield, int theirEnergy, int theirShield, Combatant *me, Combatant *them, int BATTLE_ROUND, int BATTLE_TURN)
{
  if (BATTLE_ROUND == 1000 && BATTLE_TURN == 1000 && myEnergy == 1000 && myShield == 1000 && theirEnergy == 1000 && theirShield == 1000 && me == NULL && them == NULL)
  {
    return;
  }

  if (myEnergy < 100)
  {
    recharge(me);
    return;
  }

  defend(me, myEnergy - 1);
}

void accountant_strategy(int myEnergy, int myShield, int theirEnergy, int theirShield, Combatant *me, Combatant *them, int BATTLE_ROUND, int BATTLE_TURN)
{
  if (BATTLE_ROUND == 1000 && BATTLE_TURN == 1000 && theirShield == 0 && theirEnergy == 0 && myShield == 0 && myEnergy == 0 && me == NULL && them == NULL)
  {
    return;
  }

  if (myEnergy < 30)
  {
    defend(me, myEnergy - 1);
    return;
  }

  if (myEnergy < 100)
  {
    recharge(me);
    return;
  }

  attack(me, them, 15);
}

void enemy_turn(int myEnergy, int myShield, int theirEnergy, int theirShield, Combatant *me, Combatant *them, int BATTLE_ROUND, int BATTLE_TURN)
{
  switch (BATTLE_ROUND)
  {
  case 0:
    dummy_strategy(myEnergy, myShield, theirEnergy, theirShield, me, them, BATTLE_ROUND, BATTLE_TURN);
    break;

  case 1:
    accountant_strategy(myEnergy, myShield, theirEnergy, theirShield, me, them, BATTLE_ROUND, BATTLE_TURN);
    break;

  default:

    // If we have both got a lot of energy, use it to increase our shield
    if (BATTLE_TURN == 0)
    {
      defend(me, 70);
      return;
    }

    // If the enemy has a 80% chance of killing the player then attack.
    int effective_health = theirEnergy + theirShield; // Damage required to kill the player on this move.
    int max_power = (myEnergy - 1 > 20) ? 20 : myEnergy - 1;
    int max_likely_damage = max_power * 1.2; // 80% chance of getting at least this much damage

    if (effective_health <= max_likely_damage)
    {
      // Risk it for the biscuit
      attack(me, them, max_power);
      return;
    }

    // If the player has a 65% chance of killing the enemy then shield.
    effective_health = myEnergy + myShield; // Damage required to kill the enemy on this move.
    max_power = (theirEnergy - 1 > 30) ? 30 : theirEnergy - 1;
    max_likely_damage = max_power * 1.35; // 65% chance of getting at least this much damage

    if (effective_health <= max_likely_damage)
    {
      defend(me, myEnergy - 1);
      return;
    }

    if (myEnergy < 30)
    {
      recharge(me);
      return;
    }

    // Default to zapping energy
    attack(me, them, 15);
    break;
  }
}

int main()
{
  try
  {
    // check if the terminal is capable of handling input
    if (!Term::is_stdin_a_tty())
    {
      std::cout << "The terminal is not attached to a TTY and therefore "
                   "can't catch user input. Exiting...\n";
      return 1;
    }

    Terminal term(true, true, true, true);

    string name = "INSERT_TEAM_NAME";

    Combatant *player = new Combatant(name);
    Combatant **enemies = new Combatant *[3];
    enemies[0] = new Combatant("Target Practice Dummy");
    enemies[1] = new Combatant("Dave from accounting");
    enemies[2] = new Combatant("COS284 lecturer");

    for (BATTLE_ROUND = 0; BATTLE_ROUND < 3; BATTLE_ROUND++)
    {
      Combatant *enemy = enemies[BATTLE_ROUND];

      render(player, enemy);
      Term::read_key();

      for (BATTLE_TURN = 0; BATTLE_TURN < 25; BATTLE_TURN++)
      {

        enemy_turn(enemy->getEnergy(), enemy->getShield(), player->getEnergy(), player->getShield(), enemy, player, BATTLE_ROUND, BATTLE_TURN);

        if (player->getEnergy() <= 0)
        {
          BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + player->getName() + " has been defeated!");
          break;
        }

        render(player, enemy);
        Term::read_key();

        player_turn(player->getEnergy(), player->getShield(), enemy->getEnergy(), enemy->getShield(), player, enemy, BATTLE_ROUND, BATTLE_TURN);

        if (enemy->getEnergy() <= 0)
        {
          BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + enemy->getName() + " has been defeated!");
          break;
        }

        render(player, enemy);
        Term::read_key();

        if (BATTLE_TURN == 24)
        {
          BATTLE_LOG.push_front("[" + std::to_string(BATTLE_ROUND + 1) + ":" + std::to_string(BATTLE_TURN + 1) + "] " + "The battle has ended in a draw!");
          break;
        }
      }

      if (player->getEnergy() <= 0 || BATTLE_TURN == 24)
      {
        break;
      }
    }

    // Handles the final move that ended the BATTLE_ROUND
    render(player, enemies[BATTLE_ROUND]);
    Term::read_key();

    // Clean up
    for (int i = 0; i < 3; i++)
    {
      delete enemies[i];
    }

    delete[] enemies;
    delete player;

    return 0;
  }
  catch (const std::runtime_error &re)
  {
    std::cerr << "Runtime error: " << re.what() << std::endl;
    return 2;
  }
  catch (...)
  {
    std::cerr << "Unknown error." << std::endl;
    return 1;
  }
}
