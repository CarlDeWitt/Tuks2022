#! /bin/bash

# redirect all the compile output to stderr and stop if the compile step fails
make clean 1>&2 > /dev/null
make 1>&2 > /dev/null
compiled=$?

if [[ $compiled -ne 0 ]]; then
    echo "COMPILE FAILED"
    exit $compiled
fi

# execute the compiled binary and redirect all output to stdout

echo "computer
0" | ./p2 2>&1

echo "bananana
1" | ./p2 2>&1

echo "!@#$%^&*
2" | ./p2 2>&1

echo "kingkong
3" | ./p2 2>&1

echo "12345678
4" | ./p2 2>&1