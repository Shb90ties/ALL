class myObj:
    bing = 5

    def printBring(self):
        print (self.bing)

    def printWithCompiler(self):
        print(self.bing,self.newClassObj)

#_______________________# the class ^ , self = this


object1 = object1COPY = myObj()
object2 = myObj()

object1.printBring()
object1.bing = 18
object1.printBring()
object1COPY.printBring()

object2.printBring()

class myArguments: # _____________Class with instructer
    def __init__(self, x):
        self.newOBJ = x # insert objects to the class through self
    def printOBJ(self):
        print (self.newOBJ)

object3 = myArguments(88.14)
object3.printOBJ()
print (object3.newOBJ)

class person:
    def print_name(self):
        print (self.name)

class worker(person):
    def __init__(self, name, job):
        pass # making Super class to be able to use functions
        self.name = name
        self.job = job

    def printJOB(self):
        print (self.job)

person1 = worker('Bob','Mailman')
person1.printJOB()
person1.print_name()

#________________Sorting costume made Objects____________

from operator import attrgetter

class mySortObj:
    def __init__(self,x,y):
        self.x = x
        self.y = y
    def __repr__(self):
        return self.y+self.x
    def printXY(self):
        print (self.x,',',self.y)

sortOBJ1 = mySortObj(5,2)
sortOBJ2 = mySortObj(6,8)
sortOBJ3 = mySortObj(10,1)
sortOBJ4 = mySortObj(2,2)

needToSort = [sortOBJ1,sortOBJ2,sortOBJ3,sortOBJ4]
sortedArrt = sorted(needToSort,lambda mySortObj:mySortObj.__repr__())
