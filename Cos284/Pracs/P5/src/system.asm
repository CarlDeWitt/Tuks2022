            segment .data
            struc Student
            .average resq 1
            .id resd 1
            align 8

            segment   .text
            global    filter, enrol, predict, expel, getStudentSize, getAverageOffset, getIdOffset
            extern    malloc, strcpy, free
; p *((struct Student*) variable)
enrol:
  imul rdi,16
  call malloc
  ; mov rdi,rax
  ret

predict:
;edi esi edx 
  mov rax,rsi
  imul rax,16
  add rdi,rax
  movsd [rdi],xmm0
  mov [rdi + 8],rsi
  mov rax,0
  ret



  filter:
    mov rcx, 1
    movsd xmm0, [rdi]
    add rsi,rsi
    

  while: 
    cmp rcx, rsi ;rsi is size of array
    jge end_while ; if the size is to large then end the while
    ucomisd xmm0, [rdi + 8*rcx] ; compare 
    ja not_larger
    movsd xmm0, [rdi+8*rcx]
    mov r15, rcx
    imul r15,8
    add r15,rdi
    mov rax,r15

  not_larger:
    inc rcx
    jmp while

  end_while:
    ; movsd rdi,xmm0
    ret

; Helpers
expel:
  push rbp
  mov rbp, rsp

  call free
  leave
  ret

getStudentSize:
  mov rax, 16
  ret

getAverageOffset:
  mov rax, Student.average
  ret

getIdOffset:
  mov rax, Student.id
  ret
            segment   .data