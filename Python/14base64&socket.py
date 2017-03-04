import base64
from socketIO_client import SocketIO, LoggingNamespace

#socketIO = SocketIO('localhost',1337,LoggingNamespace)
socketIO = SocketIO('https://ipet-project-server.herokuapp.com/socket.io/')
myNumber = '0547777777'


def TakeAPicture(userName):
    #______________Example func___________________________#
    print 'Image request from '+userName
    imageFile = open("iPetImageTest.jpg", "rb")
    imgBase64 = base64.b64encode(imageFile.read())
    #_______________________________________________________#
    socketIO.emit('sendImage', userName, imgBase64)


socketIO.on('TakePic'+myNumber,TakeAPicture)


#__________call from android apk_______________#
#Messg = '{"from":"username111","to":"0547777777"}'
#socketIO.emit('RequestImage', Messg)

socketIO.wait(seconds=10000)

# dissconnect client from socket
socketIO.emit("forceDisconnect")