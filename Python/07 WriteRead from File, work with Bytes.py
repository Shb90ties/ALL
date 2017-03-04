from struct import *

myfile = open('simple.txt','w')
myfile.write('overwrite first line \n')
myfile.write('overwrite second line \n')
myfile.close()

myfile = open('simple.txt','r')
text = myfile.read()
myfile.close()
print (text)

packed_data = pack('iif',6,19,43.22)    # pack the values into bytes

print(calcsize('i')) # show the size in bytes of the i value, 19
print(calcsize('if'))
print(calcsize('iif'))

print(unpack('iif',packed_data))    # unpack the values into values