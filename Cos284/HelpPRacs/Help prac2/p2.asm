segment .data

statement: dw "Your balance is", 0x0a
statement_length: equ $-statement
input: dw "", 0x0a
input_lenght: equ $-input
nextLine: dw "\n", 0x0a
nextLine_lenght: equ $-nextLine
balance: dq 10, 0x0a
balance_length: equ $-balance

section .text

output:
mov eax, 1
mov edi, 1
mov edx, nextLine_lenght
lea rsi, [nextLine]
;syscall

mov eax, 1
mov edi, 1
mov edx, statement_length
lea rsi, [statement]
syscall

mov eax, 1
mov edi, 1
mov edx, balance_length
lea rsi, [balance]
syscall
ret

inputcall:  
;clears the registers and set them all to 0
mov rax,0
mov rdi,0
mov rdx, 0
mov rsi, 0
syscall

mov rax,0
mov rdi,0
mov rdx, input_lenght
mov rsi, input
syscall

;print input
mov eax, 1
mov edi, 1
mov edx, input_lenght
lea rsi, [input]
syscall
;ret


global _start
_start:

;call output
;call inputcall

;ret

exit:
  mov eax, 60
  xor edi, edi
  syscall
