def myFunc(message):
    print (message)

myFunc("some message")

def doPlus(a,b):
    return a+b

myFunc(doPlus(5,2))

def undecidedFunc(x='default value'):
    if x is "Bob":
        print("BOB!!!")
    else:
        print(x)

undecidedFunc("Bob")
undecidedFunc()

def DefaultsFunction(x='first default',y='second default'):
    print(x+' '+y)

DefaultsFunction(y="only second one is changed")

def FlexibleAmountParemeter(*argsList):
    count = 0
    for i in argsList:
        print (count,'argument : ',i)
        count += 1

""""A list"""
ListOfArguments = ['elbow','greece','yellow']
""""A Array"""
arrayOfArguments = {'bib','teg','y'}


FlexibleAmountParemeter('David','Joe','Jon')
FlexibleAmountParemeter(*ListOfArguments)
FlexibleAmountParemeter(arrayOfArguments)

JSONargs = {'a':5,'zzzz':'sleeping','oll':51.23}

print(JSONargs)
print(JSONargs['a'],JSONargs['oll'])

for key,val in JSONargs.items():
    print(key , val)

wordsss = ['Bob','GG','Bob','hh','yoy','YTT','GG','Bob']
wordCounter = {}

for i in wordsss:
    wordCounter[i] = 0

for i in wordsss:
    wordCounter[i] += 1

print(wordsss)
print(wordCounter)

# Lambda short call functions #

answerr = lambda x : x*6 # same as lambda(x){ return x*6 }
print(answerr(5))
