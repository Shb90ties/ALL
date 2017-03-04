import base64

#_______convert to String_________
imageFile = open("test.png", "rb")
str = base64.b64encode(imageFile.read())
#_________save on file_________
textFile = open("simple.txt","w")
textFile.write(str)
print str

#____________save as img________
def SaveImage(image):
    print image
    fh = open("CopyFromBase64.png", "wb")
    fh.write(image.decode('base64'))
    fh.close()

#______convert back to img__________
fh = open("CopyFromBase64.png", "wb")
fh.write(str.decode('base64'))
fh.close()

