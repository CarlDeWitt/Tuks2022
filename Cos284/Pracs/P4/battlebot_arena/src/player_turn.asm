 extern attack
 extern defend
 extern recharge

  global player_turn
player_turn:
  .myEnergy equ 0
  .myShield equ 4
  .theirEnergy equ 8
  .theirShield equ 12
  .me equ 16
  .them equ 24
  .BATTLE_ROUND equ 32
  .BATTLE_TURN equ 36

  ; Create the stack frame
   push rbp
  mov rbp, rsp
  
  ; Subtract stack pointer to put local variables on 16-byte boundary

    sub rsp, 48
  ; Save the arguments to the stack using local variable offsets
  mov dword [rsp + player_turn.myEnergy], edi
  mov dword [rsp + player_turn.myShield], esi
  mov dword [rsp + player_turn.theirEnergy], edx
  mov dword [rsp + player_turn.theirShield], ecx
  mov qword [rsp + player_turn.me], r8
  mov qword [rsp + player_turn.them], r9

    ; Handle stack params
  mov eax, dword [rbp + 16]
  mov dword [rsp + player_turn.BATTLE_ROUND], eax
  mov eax, dword [rbp + 24]
  mov dword [rsp + player_turn.BATTLE_TURN], eax

  ; call attackFunc
  ; call defendFunc
  ; call rechargeFunc  

  ; Implement a strategy
  mov edi, qword [rsp + player_turn.me]
  mov esi, qword [rsp + player_turn.them]
  mov edx, dword [rsp + player_turn.myEnergy]
  call attack

  mov edi, qword [rsp + player_turn.me]
  mov esi, dword [rsp.theirShield]
  call defend

  mov edi, qword [rsp + player_turn.them]
  call recharge
  ; call .exit

  ; .defend:
  ; mov edi, dword [rsp + player_turn.me]
  ; mov esi, dword [rsp + player_turn.them]
  ; mov edx, 25
  ; call attack  
.exit:
  ; Destory the stack frame
  mov rsp, rbp ; Restore the stack pointer
  pop rbp
  ret