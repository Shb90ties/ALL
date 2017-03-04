from random import randint

bitsArray = []
Sum = 0
n = randint(60,160)
for i in range(n):
    j = randint(0,70)
    bitsArray.append(j)
    if j > 49:
        Sum += 1
bpm = Sum*4
print bitsArray
print bpm