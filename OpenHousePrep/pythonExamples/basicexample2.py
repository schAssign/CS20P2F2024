while True: # this is a loop. It will repeat infinitely, unless interrupted.
    
    print("please input a value: (input 0 to quit)") # we use print statements to give information to the user, such as instructions.

    theUsersInput = input() # get the user's input, and store it in a variable. The variable can have almost any name, as long as it is the same throughout the program.

    print("you inputted: " + (str)(theUsersInput) + "\n") # you can combine (concatenate) items, so that they fit inside one print statement

    if (theUsersInput) == "0": # if the user inputted 0, like we said, we can end the loop. the quotation marks mean that the value is treated like a word, rather than a number. the double equals sign checks to make sure two things are equal.
        break

print("goodbye!")