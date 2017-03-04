print("Basic summery, right-click Run 'Test'")
# Bitwise operators_________________
a = 3 # 11
b = 4 # 100
c = a & b # 11 & 100 = (1&1 = 0 , 1&0 = 0) 000
print(c)
c = b << 2 # <<  = times 2, >> = divide by 2
print(c)
# Arrays_____________________________
x = [1,2,3,4,5]
print(x[:])
print(x.__len__())
print(x[:2])
print(x[2:])
x[:3] = []
print(x)
number = 55
stringg = 'gggg'
print ("print number: "+ str(number) +" with a string: "+stringg)
stringNumber = '56'
print ('Add number and number in a string ', number+int(stringNumber))
x.append(45)
print(x)
print(x[2])
x = []
print(x)
x.append([74,80])
x.append(55)
print(x)
print(x[0])
y=["Bob","Elen","Beef"]
print(y)

Datee ,Namee ,Numbeer = ['December 23, 2015','Bob',555.2]

print(Datee)
print(Namee)
print(Numbeer)

numberss = [1,2,3]
first, middle, last = numberss

print(first,middle,last)

# ZIP making pairs #

firstNames = ['Bob','Yon','Leen']
lastNames = ['Kinm','TTPT','Uuretra']

fullNames = zip(firstNames,lastNames)

for a,b in fullNames:
    print('first Name :'+a+' ,last Name : '+b)

stocks = {
    'KOK' : 55,
    'OOP' : 105,
    'Kill' : 5
}
            # put the value first, will be the number it sort with
print(sorted(zip(stocks.values(),stocks.keys())))
print(min(zip(stocks.values(),stocks.keys())))
print(max(zip(stocks.values(),stocks.keys())))

#______ Get min max
import heapq

sstt = [{'name':'Hoo','num':15},{'name':'Haa','num':18},{'name':'Hii','num':13}]

print ('smallest',heapq.nsmallest(1,sstt,key=lambda sstt: sstt['num']))
                                # amount of results,list,method of getting smallest

#_______ READ SORTED ARRAY

arrTTY = [1,5,4,2,8,6]
output = []
for i in sorted(arrTTY):
    output.append(i)
print(output)

from operator import itemgetter

arrJSONT = [{'g':'b'},{'g':'bbbbb'},{'g':'bb'},{'g':'bbb'},{'g':'bbbb'}]
output = []
for i in sorted(arrJSONT,key=itemgetter('g')):
    output.append(i)
print(output)