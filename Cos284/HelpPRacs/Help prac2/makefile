p1: p1.asm 
	yasm -f elf64 -g dwarf2 -l p1.lst p1.asm 
	ld -s -o p1.out p1.o 
	./p1.out
clean: 
	rm -f p1 p1.o p1.lst p1.out
