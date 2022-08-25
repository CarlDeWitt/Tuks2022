segment .data

welcome: dw "Welcome to ASM Integer Bank!", 0x0a
welcomeLen: equ $-welcome
msg1: dw 27, "[31mALERT! Password have been leaked", 0x0a
msg1Len: equ $-msg1
msg2: dw 27, "[0mPlease follow the instructions to reset your Password", 0x0a
msg2Len: equ $-msg2
msg3: dw 27,"[0m  Password lenght must be exactly 8 characters", 0x0a
msg3Len: equ $-msg3
msg4: dw 27,"[0m  Password cannnot be the same as old Password", 0x0a
msg4Len: equ $-msg4
msg5: dw 27,"[0m  Password cannnot contain high risk string p@ss ", 0x0a
msg5Len: equ $-msg5
oldpasswMSG: db 27,"[0mYou cannot enter your old Password",0x0a
oldpasswMSGLen: equ $-oldpasswMSG
riskypass: db 27,"[31mPassword contains high risk string",0x0a
riskypassLen: equ $-riskypass
valid db 27,"[32mPassword updated successfully!",0x0a
validLen equ $- valid
pasw: db "New Password: ", 
paswLen: equ $-pasw
oldpassw dq  "12345678"
trash dq 0
input dq 0 
nextLine dw 0x0a
risky dq "p@ss", 0x0a


section .text

wlecomemsg:
mov eax, 1
mov edi, 1
mov edx, welcomeLen
lea rsi, [welcome]
syscall

mov eax, 1
mov edi, 1
mov edx, msg1Len
lea rsi, [msg1]
syscall

mov eax, 1
mov edi, 1
mov edx, msg2Len
lea rsi, [msg2]
syscall

mov eax, 1
mov edi, 1
mov edx, msg3Len
lea rsi, [msg3]
syscall

mov eax, 1
mov edi, 1
mov edx, msg4Len
lea rsi, [msg4]
syscall

mov eax, 1
mov edi, 1
mov edx, msg5Len
lea rsi, [msg5]
syscall

ret

inputcall:  
;--get the input
mov rax,0
mov rdi,0
mov rsi, input
mov rdx, 8
syscall

mov rax,0
mov rdi,0
mov rsi, trash
mov rdx, 1
syscall

ret

print:
mov eax, 1
mov edi, 1
lea rsi, [input]
mov edx, 8
syscall
; call NewLine

ret

NewLine:
mov rax, 1
mov rdi, 1
mov rsi, nextLine
mov edx, 1
syscall
ret

enterpasw:
mov eax, 1
mov edi, 1
mov edx, paswLen
lea rsi, [pasw]
syscall
call inputcall
call checkpasw
ret

oldpassword:
mov eax, 1
mov edi, 1
mov edx, oldpasswMSGLen
lea rsi, [oldpasswMSG]
syscall
call enterpasw

printRisky:
mov eax, 1
mov edi, 1
mov edx, riskypassLen
lea rsi, [riskypass]
syscall
call enterpasw

nextCheck:
mov rax, "p@ss"
mov rbx, [input]
call checkforRisky

validmsg:
mov eax, 1
mov edi, 1
mov edx, validLen
lea rsi, [valid]
syscall
call exit

checkforRisky:
cmp ebx, "p@ss"
jz printRisky
shr rbx,8
cmp rbx,0
jz validmsg

jmp checkforRisky

checkpasw:
mov eax, [input]
mov edi, [oldpassw]
cmp eax,edi
jz oldpassword
jnz nextCheck

global _start
_start:

call wlecomemsg
call enterpasw

call NewLine
call exit

exit:
  mov eax, 60
  xor edi, edi
  syscall
