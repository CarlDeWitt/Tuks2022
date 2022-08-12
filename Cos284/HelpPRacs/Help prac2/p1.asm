;For Loop

section .data

msg1: db "Hello World ", 0xA
msg2: db "lekker man hoe gaan dit", 0xA
input: db "" , 0xA
n: dq 1        ;for loop iterations

section .text

global _start
_start:

mov rax, 0
mov rdi, 0
mov rsi, input
mov rdx,3
syscall

mov rax, 1
mov rdi, 0
lea rsi, [input]
mov rdx, 6
syscall

mov rbx, [n]
mov r8,1

for:
cmp r8, rbx     ;compare counter to n
jg end_for

mov eax, 1
mov edx, 13
lea rsi, [msg1] ;Load effective address
syscall
inc r8          ;iterator increment
jmp for
end_for:

mov eax, 60     ;exit

syscall