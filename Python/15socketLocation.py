from socketIO_client import SocketIO, LoggingNamespace
from random import randint

#socketIO = SocketIO('localhost',1337,LoggingNamespace)
socketIO = SocketIO('https://ipet-project-server.herokuapp.com/socket.io/')
myNumber = '0547777777'

def GivePetLocation(userName):
    #_____________example func_________________________________________________#
    errorGPS = randint(0,3)
    lonRs = '34.89' + str(randint(71000, 89000))
    lonR = float(lonRs)
    lanRs = '32.445' + str(randint(100, 9000))
    lanR = float(lanRs)
    if errorGPS == 2:
        lanR = 0
        lonR = 0
    print 'sending location to '+userName+'( '+str(lanR)+' , '+str(lonR)+' )'
    #__________________________________________________________________________#
    socketIO.emit('GiveLocation', userName, lanR, lonR)

socketIO.on('sendLocation'+myNumber, GivePetLocation)


#________________Android app call___________________
#socketIO.emit('GetLocation', 'userAAA', myNumber)


socketIO.wait(seconds=10000)

# dissconnect client from socket
socketIO.emit("forceDisconnect")