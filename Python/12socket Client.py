# import socket
from socketIO_client import SocketIO, LoggingNamespace

def Client(message):
    print(message)

# install socket object
#socketIO = SocketIO('localhost',1337,LoggingNamespace)
socketIO = SocketIO('http://ipet-project-server.herokuapp.com/socket.io/')

def sendMessageWithSocket(title,message):
    socketIO.emit(title,message)

sendMessageWithSocket('Server','message to serverR')

# catch messages with titles 'Client'
socketIO.on('Client',Client)


# keep program alive
socketIO.wait(seconds=30)

# dissconnect client from socket
socketIO.emit("forceDisconnect")