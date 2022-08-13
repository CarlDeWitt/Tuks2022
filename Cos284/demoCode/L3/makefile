p2: l3.asm 
	yasm -f elf64 -g dwarf2 -l l3.lst l3.asm 
	ld -s -o l3.out l3.o 
	./l3.out
clean: 
	rm -f l3 l3.o l3.lst l3.out
debug:
	gdb 34
clean:
	rm l3.o l3