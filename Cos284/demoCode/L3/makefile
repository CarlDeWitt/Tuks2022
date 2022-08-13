l3: l3.o
	ld -o l3 l3.o

l3.o:
	yasm -f elf64 -g dwarf2 l3.asm
	
run:
	./l3

debug:
	gdb l3

clean:
	rm l3.o l3