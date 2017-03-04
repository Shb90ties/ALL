"""Ifs & Fors"""

name = "Bob"

if name is "Bip":
    print("Name is bip")
elif name is "Bob":
    print("Name is BOB")
elif name is "ben":
    print("Name is ben")
else:
    print ("NONE of the names matched")

arrayY = ["DD","FF","GGG"]

for a in arrayY:
    print(a)
    if a is "FF":
        print(len(a))
    if a is "GGG":
        for c in a[:]:
            print(a+c)
            a = a+c

arrNew = []
for i in range(10):
    arrNew.append(i)
print(arrNew)

arrNew = []
for i in range(5,12):
    arrNew.append(i)
print(arrNew)


arrNew = []
for i in range(1,20,3):
    arrNew.append(i)
print(arrNew)

Gooo = 3
while Gooo >= 0:
    print(Gooo)
    Gooo = Gooo-1

print(11,' number with string')

numberTwentySix = 26
for i in range(40):
    if i is numberTwentySix:
        print (i,' number twenty six & break')
        break
    else:
        if i%6 is 0:
            print(i,'not twenty six divids by 6')

arrNumsToSkip = [2,5,7,8,9]
for i in range(10):
    if i in arrNumsToSkip:
        continue
    print(i,"didnt continue/skip on this")



# Maps put outputs of functions with arrays into a list

numbrrr = [10,20,30]

def multiplyByTwo(num):
    return num*2

MappedListWithFunction = list(map(multiplyByTwo,numbrrr))
print(MappedListWithFunction)