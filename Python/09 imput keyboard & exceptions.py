while True:
    try:
        numberFromUser = int(input("insert a number to divide 18?\n"))
        print (18/numberFromUser)
        break   # Breaks the while loop if everything was okay
    except ValueError:
        print("Please insert a number")
    except ZeroDivisionError:
        print ("Cannot divide by zero")
    finally:
        print ("Loop is over")