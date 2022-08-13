  global _start
  segment .text

; set disassembly-flavor intel 
; info registers all 
; info registers eax
; layout r
; p/x $rax
; p (char[8]) $rax

_start:
; Given:
; a = 10
; b = 100
; c = 25
; d = 0
; 
; Do:
; a = -a
; d = (((20 + a + 1) + (b - c - 1)) * b) % 12

; Negating a memory value
  neg qword [a]

; rax = 20
  mov rax, 20
; a = a + 20
  add [a], rax
; a = a + 1
  inc qword [a]

; rax = 100
  mov rax, [b]
; rax = b - c
  sub rax, [c]
; rax = rax - 1 
  dec rax

; rax = rax + a 
  add rax, byte [a]

; rax = rax * b
  imul rax, [b]
; rdx = 0
  xor rdx, rdx
; rax = [quotient]
; rdx = [remainder]
  mov rcx, 12
  idiv rcx

  mov [d], rdx

exit:
  mov rax, 60
  xor rdi, rdi
  syscall

segment .data
a     db    10
b     dq    100
c     dq    25
d     dq    0