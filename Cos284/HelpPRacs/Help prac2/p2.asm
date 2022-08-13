segment .data

welcome: dw "Welcome to ASM Integer Bank!", 0x0a
welcomeLen: equ $-welcome
statement: dw "Balance: ", 0x0a
statementLen: equ $-statement
transtype1: dw "Please select your transaction type:", 0x0a
transtypeLen1: equ $-transtype1
transtype2: dw "1. Withdraw R10", 0x0a
transtypeLen2: equ $-transtype2
transtype3: dw "2. Deposit R5", 0x0a
transtypeLen3: equ $-transtype3
transtype4: dw "3. Exit", 0x0a
transtypeLen4: equ $-transtype4
rem: dw "", 0x0a
divs: dw "10", 0x0a
balance dq  15
nextLine dw 0x0a
num1 dq 0
num2 dq 0
input: dw "", 0x0a
text: dd "wassup",

section .text

NewLine:
mov rax, 1
mov rdi, 1
mov rsi, nextLine
mov edx, 1
syscall
ret

balanceasciiConversion:
;--splits balance into 2 integers
mov rax, [balance]; --prepare for divide
add rdx, 0; --have to make 0 to div
mov rcx, 10; --divisor
idiv rcx
;--rax = quotient
;--rdx = remainder
;--+48 to get asciiConversion
add rax, 48
mov [num1], rax
add rdx, 48
mov [num2], rdx

;--print
mov rax,1
mov rdx,1
mov rsi, num1
mov rdx, 1
syscall

mov rax,1
mov rdx,1
mov rsi, num2
mov rdx, 1
syscall
call NewLine
ret

welcomeMSG:

mov eax, 1
mov edi, 1
mov edx, welcomeLen
lea rsi, [welcome]
syscall

mov eax, 1
mov edi, 1
mov edx, statementLen
lea rsi, [statement]
syscall

;call balanceasciiConversion

mov eax, 1
mov edi, 1
mov edx, transtypeLen1
lea rsi, [transtype1]
syscall

mov eax, 1
mov edi, 1
mov edx, transtypeLen2
lea rsi, [transtype2]
syscall


mov eax, 1
mov edi, 1
mov edx, transtypeLen3
lea rsi, [transtype3]
syscall

mov eax, 1
mov edi, 1
mov edx, transtypeLen4
lea rsi, [transtype4]
syscall
ret

testsplit:
lea rsi, [text +0]
mov rdx, 1
mov [num1], rdx
syscall

mov rax,1
mov rdx,1
mov rsi, num1
mov rdx, 1
syscall

call NewLine

ret

inputcall: 
;--get the input
mov rax,0
mov rdi,0
mov rsi, input
mov rdx, 1
syscall

;mov rax, 1
mov rdi, 1
mov rsi, input
mov rdx, 1
syscall

call NewLine
ret


global _start
_start:

;call welcomeMSG
;call balanceasciiConversion
;call testsplit
call inputcall

exit:
  mov eax, 60
  xor edi, edi
  syscall
