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
balance dq  12
nextLine dw 0x0a
num1 dw 0
num2 dw 0

section .text

NewLine:
mov rax, 1
mov rdi, 1
mov rsi, nextLine
mov edx, 1
syscall
ret

asciiConversion:
mov rax, [balance]
add rdx, 0
mov rcx, 10
idiv rcx
add rax, 48
mov [num1], rax
add rdx, 48
mov [num2], rdx

mov rax,1
mov rdx,1
mov rsi, num1
mov rdx, 1
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
call NewLine
ret

inputcall:  
;clears the registers and set them all to 0
mov rax,0
mov rdi,0
mov rdx,0
mov rsi,0
syscall

;mov rax,0
;mov rdi,0
;mov rdx, input_lenght
;mov rsi, input
;syscall

;print input
;mov eax, 1
;mov edi, 1
;mov edx, input_lenght
;lea rsi, [input]
;syscall
;ret


global _start
_start:

;call welcomeMSG
call asciiConversion
;call inputcall

;ret

exit:
  mov eax, 60
  xor edi, edi
  syscall
