from socketIO_client import SocketIO, LoggingNamespace
from random import randint

#socketIO = SocketIO('localhost',1337,LoggingNamespace)
socketIO = SocketIO('https://ipet-project-server.herokuapp.com/socket.io/')
myNumber = '0547777777'

def GivePetPulse(userName):
    #________________Example func____________________________#
    print 'sending pulse to '+userName
    bitsArray = []
    Sum = 0
    n = randint(60, 160)
    for i in range(n):
        j = randint(0, 70)
        bitsArray.append(j)
        if j > 49:
            Sum += 1
    bpm = Sum * 4
    print bitsArray
    print ('bpm : ',bpm,'n : ',n)
    #________________________________________________________#
    socketIO.emit('GivePulse', userName, bitsArray, bpm)


socketIO.on('sendHeartBit'+myNumber, GivePetPulse)

#___________for the android app______________
#socketIO.emit('GetPulse', 'userAAA', myNumber)


socketIO.wait(seconds=10000)

# dissconnect client from socket
socketIO.emit("forceDisconnect")