This directory contains most of the code to implement a RPN calculator in JAVA. You will need to add a queue implementation and a stack implementation to complete the project. After implementing and testing your queue and stack, you will need to update RPN.java to instantiate your implementations. No other changes should needed to the scaffold code.

The RPN calculator functions on the command line and interprets all values as doubles. Since the shell converts * to filenames, when using the * operator you will need to put it in quotes.

So that you can get a sense of how the program works before your implementation is complete, compiled byte code is included for a ring queue and linked list based stack. _DO_NOT_INCLUDE_THESE_.class_FILES_IN_YOUR_SUBMISSION_.

Usage Examples:
kiera:rpn dellswor$ java RPN 1 2 3 + '*'
Answer is: 5.0
kiera:rpn dellswor$ java RPN 6 3 / 1 -
Answer is: 1.0
kiera:rpn dellswor$ java RPN 1 1 1 1 1 + 1 1 1 1 1 + 1 + + + + + + + + +
Underflow when popping stack
Answer is: 0.0
kiera:rpn dellswor$ java RPN 1 1 1 1 1 + 1 1 1 1 1 + 1 + + + + + + + +
Answer is: 11.0


Files:
RPN.java           - RPN calculator main
RPNCore.java       - The core logic for an RPN calculator
RPNToken.java      - Interface for things the calculator can process
RPNValueToken.java - Representation for a value
RPNOpToken.java    - Representation for an operator
IQueue.java        - Interface to hold the sequence of operations
IStack.java        - Interface for the operand stack
OverFlowException.java      - Exception for over filling a data structure		
UnderFlowException.java     - Exception for over emptying a data structure
BadExpressionException.java - Exception for leftover tokens in the calculator
UnknownOpException.java     - Exception for using an unknown operator
RingQueue.class      - A compiled ring queue
LinkStack.class      - A compiled link based stack
LinkStack$Link.class - A compiled link implementation for the stack

