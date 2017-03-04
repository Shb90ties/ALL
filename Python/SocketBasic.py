from socketIO_client import SocketIO, LoggingNamespace
from random import randint

myNumber = '0547777777'
socketIO = SocketIO('https://ipet-project-server.herokuapp.com/socket.io/')

def GivePetPulse(userName):
    print 'recieved pulse Request from '+userName
    #socketIO.emit('GivePulse', userName, bitsArray, avgBIT)


socketIO.on('sendHeartBit'+myNumber, GivePetPulse)

#___________for the android app______________
socketIO.emit('GetPulse', 'userAAA', myNumber)


socketIO.wait(seconds=10000)

# dissconnect client from socket
socketIO.emit("forceDisconnect")