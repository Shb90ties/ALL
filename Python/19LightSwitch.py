from socketIO_client import SocketIO, LoggingNamespace

#socketIO = SocketIO('localhost',1337,LoggingNamespace)
socketIO = SocketIO('https://ipet-project-server.herokuapp.com/socket.io/')
myNumber = '0547777777'


def TurnONoffLight(lightValue):
    print 'turn the light ' + lightValue

socketIO.on('Light'+myNumber,TurnONoffLight)


#__________call from android apk_______________#
#1) socketIO.emit('LightSwitch', '0547777777', 'on');
#2) socketIO.emit('LightSwitch', '0547777777', 'off');

socketIO.wait(seconds=10000)

# dissconnect client from socket
socketIO.emit("forceDisconnect")