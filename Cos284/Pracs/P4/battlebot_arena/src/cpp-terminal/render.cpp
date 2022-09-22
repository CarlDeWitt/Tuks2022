#include <cpp-terminal/render.h>

int PLAYER_NAME_X = 1;
int PLAYER_NAME_Y = 1;
int PLAYER_ENERGY_X = 1;
int PLAYER_ENERGY_Y = 4;
int PLAYER_SHIELD_X = 1;
int PLAYER_SHIELD_Y = 7;
int PLAYER_SCORE_X = 1;
int PLAYER_SCORE_Y = 10;

int ENEMY_NAME_X = 52;
int ENEMY_NAME_Y = 1;
int ENEMY_ENERGY_X = 52;
int ENEMY_ENERGY_Y = 4;
int ENEMY_SHIELD_X = 52;
int ENEMY_SHIELD_Y = 7;
int ENEMY_SCORE_X = 52;
int ENEMY_SCORE_Y = 10;

int BATTLE_LOG_X = 1;
int BATTLE_LOG_Y = 14;

int BATTLE_LOG_MAX = 6;

void render(Combatant* player, Combatant* enemy) {
  std::string current_frame[23][102];
  std::copy(&CANVAS[0][0], &CANVAS[0][0] + 23 * 102, &current_frame[0][0]);

  std::string scr;
  scr.reserve(16 * 1024);
  scr.append(move_cursor(1, 1));

  for (int row = 0; row < 23; row++)
  {
    for (int col = 0; col < 102; col++)
    {
      // append the player name
      if (row == PLAYER_NAME_Y && col == PLAYER_NAME_X) {
        // make the text blue
        scr.append(color(fg::blue));
        scr.append(player->getName());
        col += player->getName().length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the player energy
      if (row == PLAYER_ENERGY_Y && col == PLAYER_ENERGY_X) {
        if (player->getEnergy() > 50) {
          scr.append(color(fg::green));
        } else {
          scr.append(color(fg::red));
        }
        scr.append(std::to_string(player->getEnergy()));
        col += std::to_string(player->getEnergy()).length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the player shield
      if (row == PLAYER_SHIELD_Y && col == PLAYER_SHIELD_X) {
        if (player->getShield() > 50) {
          scr.append(color(fg::green));
        } else {
          scr.append(color(fg::red));
        }
        scr.append(std::to_string(player->getShield()));
        col += std::to_string(player->getShield()).length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the player score
      if (row == PLAYER_SCORE_Y && col == PLAYER_SCORE_X) {
        scr.append(std::to_string(player->getScore()));
        col += std::to_string(player->getScore()).length() - 1;
        continue;
      }

      // append the enemy name
      if (row == ENEMY_NAME_Y && col == ENEMY_NAME_X) {
        scr.append(color(fg::red));
        scr.append(enemy->getName());
        col += enemy->getName().length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the enemy energy
      if (row == ENEMY_ENERGY_Y && col == ENEMY_ENERGY_X) {
        if (enemy->getEnergy() > 50) {
          scr.append(color(fg::green));
        } else {
          scr.append(color(fg::red));
        }
        scr.append(std::to_string(enemy->getEnergy()));
        col += std::to_string(enemy->getEnergy()).length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the enemy shield
      if (row == ENEMY_SHIELD_Y && col == ENEMY_SHIELD_X) {
        if (enemy->getShield() > 50) {
          scr.append(color(fg::green));
        } else {
          scr.append(color(fg::red));
        }
        scr.append(std::to_string(enemy->getShield()));
        col += std::to_string(enemy->getShield()).length() - 1;
        scr.append(color(fg::reset));
        continue;
      }

      // append the enemy score
      if (row == ENEMY_SCORE_Y && col == ENEMY_SCORE_X) {
        scr.append(std::to_string(enemy->getScore()));
        col += std::to_string(enemy->getScore()).length() - 1;
        continue;
      }

      // Append "Press any key to continue..." as the last line of the battle log
      if (row == BATTLE_LOG_Y + BATTLE_LOG_MAX && col == BATTLE_LOG_X) {
        scr.append(color(fg::yellow));
        scr.append("Press any key to continue...");
        col += 27;
        scr.append(color(fg::reset));
        continue;
      }

      if (((row >= BATTLE_LOG_Y ) && (row < (BATTLE_LOG_Y + BATTLE_LOG_MAX))) && col == BATTLE_LOG_X) {
        int log_index = row - BATTLE_LOG_Y;
        int counter = 0;
        
        for (std::string message : BATTLE_LOG) {
          
          if (counter == log_index) {
            if (counter == 0) {
              scr.append(color(fg::white));
            } else {
              scr.append(color(fg::gray));
            }
            scr.append(message);
            col += message.length();
            scr.append(color(fg::reset));
            break;
          }

          counter++;
        }
      }

      scr.append(current_frame[row][col]);
    }

    scr.append(" \n");
  }

  std::cout << scr << std::flush;
}