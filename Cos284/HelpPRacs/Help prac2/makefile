p3: p3.o
	ld -o p3 p3.o
p3.o:
	yasm -f elf64 -g dwarf2 p3.asm
run:
	./p3
debug:
	gdb p3
clean:
	rm -f p3.o p3 p3.lst p3.out