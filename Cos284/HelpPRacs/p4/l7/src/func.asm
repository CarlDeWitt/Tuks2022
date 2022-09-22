; x/1dg $rsp
  extern print_rand
; void print_price(int a, int b, int c, int d, int e, int f, int g)
; \  / \  label  / \edi/  \esi/  \edx/  \rcx/  \/
;
; print_total is a non-leaf function because it calls another function
  ; Using global keyword to make it accessible from C++
  global print_total
print_total:
; Define local variables
  .a equ 0
  .b equ 4
  .c equ 8
  .d equ 12
  .e equ 16
  .f equ 20
  .g equ 24
  .h equ 28
; Create the stack frame
  ; Push any 8-byte value to the stack to fix 16-byte alignment
  ; Always use rbp for this
  push rbp
  mov rbp, rsp

  ; Subtract enough space for local variables on a 16-byte boundary
  sub rsp, 32
; Store the params in local variables
  ; Handle register params first
  mov dword [rsp + print_total.a], edi
  mov dword [rsp + print_total.b], esi
  mov dword [rsp + print_total.c], edx
  mov dword [rsp + print_total.d], ecx
  mov dword [rsp + print_total.e], r8d
  mov dword [rsp + print_total.f], r9d

  ; Handle stack params
  mov eax, dword [rbp + 16]
  mov dword [rsp + print_total.g], eax
  mov eax, dword [rbp + 20]
  mov dword [rsp + print_total.h], eax

  ; Call custom_add with first batch of values
  mov edi, dword [rsp + print_total.a]
  mov esi, dword [rsp + print_total.b]
  mov edx, dword [rsp + print_total.c]
  mov ecx, dword [rsp + print_total.d]
  call custom_add
  
  ; Print out result stored in eax
  mov edi, eax
  call print_rand

  ; Call custom_add with second batch of values
  mov edi, dword [rsp + print_total.e]
  mov esi, dword [rsp + print_total.f]
  mov edx, dword [rsp + print_total.g]
  mov ecx, dword [rsp + print_total.h]
  call custom_add

  ; Print out result stored in eax
  mov edi, eax
  call print_rand

; Destroy the stack frame
  mov rsp, rbp ; Restore the stack pointer
  pop rbp
  ret

;  int         custom_add           (int q, int w, int e, int r)
; \eax/        \ label  /            \edi/  \esi/  \edx/  \ecx/
;
; custom_add is a leaf function because it does not call another function
custom_add:
  ; No stack frame needed

  ; Add the 4 params
  mov eax, edi
  add eax, esi
  add eax, edx
  add eax, ecx

  ret