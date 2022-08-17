p2: p2.asm 
	yasm -f elf64 -g dwarf2 -l p2.lst p2.asm 
	ld -o p2 p2.o

clean:
	rm *.o *.lst p2

run:
	./p2