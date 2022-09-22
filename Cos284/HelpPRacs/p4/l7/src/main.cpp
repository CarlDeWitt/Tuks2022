#include <iostream>
#include <string>

using namespace std;

/* 
 * Lecture 7 Class demonstration - Steven Jordaan
 *
 * 1. make clean, make debug, gdb build/apps/main, b main, layout r, run
 * 1.1 What are the first two lines of main doing?
 * 1.2 Why is main doing this?
 * 
 * 2. Add local variable to main (int x = 0;), repeat 1.
 * 2.1 What has changed? Why?
 * 2.2 How are the params being "passed" to print_total?
 * 2.3 Why are we using 32 bit registers instead of 64 bit?
 * 
 * 3. Why does main have the following instructions:
 * 3.1 add rsp, 16 (After the call to print_total) - Hint: we push to the stack
 * 3.2 mov eax, 0 - Hint: What does rax mean in terms of a function?
 * 3.3 leave - Hint: It is syntactic sugar for two atomic instructions
 * 
 * 4. Step through the program with ni and step to enter print_total
 * 4.1.1 What is the base pointer (rbp) inside main before pushing?
 * 4.1.2 What is the base pointer (rbp) inside main after pushing?
 * 
 * -- What is an unintended side effect of the call instruction?
 * 
 * 4.2.1 What all have we pushed to the stack since entering main?
 * -- Since rbp holds the entry point for print_total, when we alter rsp, we can use rbp to look at local variables
 * 
 * -- Look at the difference between the source file func.asm and 
 *    the gdb asm with regards to local stack variables
 * 
 * 4.3 Why do we subtract 32 from rsp inside print_total?
 * -- Step into custom add
 * 4.4 Why is there no stack frame for custom_add?
 * 4.5 When would we need a stack frame for custom_add?
 * 4.6 Why are we moving the eax into edi before calling print_rand?
*/

extern "C" {
  // External Assembly Functions
  void print_total(int a, int b, int c, int d, int e, int f, int g, int h);
  
  // CPP functions that need to be called in Assembly 
  void print_rand(int x) {
    cout << "R" << x << ".00" << endl;
  }
}

int main() {
  int testing = 10;
  // Add the first 4 values up and print their value in ZAR
  print_total(1, 2, 3, 4, 5, 6, 7, 8);
  
  return 0;
}
