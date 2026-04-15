BEGIN
    DISPLAY "Enter infix expression"
    READ infix

    REPEAT
        DISPLAY "Convert to (postfix/prefix)?"
        READ choice

        IF choice = "postfix" THEN
            result ← InfixToPostfix(infix)
            DISPLAY result
        ELSE IF choice = "prefix" THEN
            result ← InfixToPrefix(infix)
            DISPLAY result
        ELSE
            DISPLAY "Invalid choice, please enter either postfix or prefix"
        END IF
    UNTIL choice = "postfix" OR choice = "prefix"

    DISPLAY "Program ended"
END