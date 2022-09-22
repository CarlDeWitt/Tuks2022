CXX      := g++
CXXFLAGS := -std=c++17 -pedantic-errors -Wall -Wextra -Werror -no-pie
LDFLAGS  := -L/usr/lib -lstdc++ -lm
BUILD    := ./build
OBJ_DIR  := $(BUILD)/objects
APP_DIR  := $(BUILD)/apps
TARGET   := main
INCLUDE  := -Iinclude/
SRC      := $(wildcard src/combatant/*.cpp) $(wildcard src/*.cpp) $(wildcard src/*.asm) $(wildcard src/cpp-terminal/*.cpp) $(wildcard src/cpp-terminal/private/*.cpp)

CPP_OBJ  := $(SRC:%.cpp=$(OBJ_DIR)/%.o)
OBJECTS  := $(CPP_OBJ:%.asm=$(OBJ_DIR)/%.o)
DEPENDENCIES \
				:= $(OBJECTS:.o=.d)

all: build $(APP_DIR)/$(TARGET)

$(OBJ_DIR)/%.o: %.cpp
	@mkdir -p $(@D)
	$(CXX) $(CXXFLAGS) $(INCLUDE) -c $< -MMD -o $@

$(OBJ_DIR)/%.o: %.asm
	@mkdir -p $(@D)
	yasm -f elf64 $< -o $@

$(APP_DIR)/$(TARGET): $(OBJECTS)
	@mkdir -p $(@D)
	$(CXX) $(CXXFLAGS) -o $(APP_DIR)/$(TARGET) $^ $(LDFLAGS)

-include $(DEPENDENCIES)

.PHONY: all build clean debug release info

build:
	@mkdir -p $(APP_DIR)
	@mkdir -p $(OBJ_DIR)

debug: CXXFLAGS += -DDEBUG -g
debug: all

release: CXXFLAGS += -O2
release: all

clean:
	-@rm -rvf $(OBJ_DIR)/*
	-@rm -rvf $(APP_DIR)/*

info:
	@echo "[*] Application dir: ${APP_DIR}     "
	@echo "[*] Object dir:      ${OBJ_DIR}     "
	@echo "[*] Sources:         ${SRC}         "
	@echo "[*] Objects:         ${OBJECTS}     "
	@echo "[*] Dependencies:    ${DEPENDENCIES}"

run:
	./$(APP_DIR)/$(TARGET)
