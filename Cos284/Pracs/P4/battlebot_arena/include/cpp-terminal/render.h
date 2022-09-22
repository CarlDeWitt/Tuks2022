#pragma once

#include <cpp-terminal/base.hpp>
#include <cpp-terminal/input.hpp>
#include <iostream>
#include <combatant/Combatant.h>
#include <cpp-terminal/constants.hpp>
#include <algorithm>

using Term::bg;
using Term::color;
using Term::cursor_off;
using Term::cursor_on;
using Term::fg;
using Term::Key;
using Term::move_cursor;
using Term::style;
using Term::Terminal;

void render(Combatant*, Combatant*);