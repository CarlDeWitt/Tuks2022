p2: p2.o
	ld -o p2 p2.o
p2.o:
	yasm -f elf64 -g dwarf2 p2.asm
run:
	./p2
debug:
	gdb p2
clean:
	rm -f p2.o p2 p2.lst