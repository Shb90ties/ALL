var app = require('express');
var http = require('http').Server(app);
var io = require('socket.io')(http);

var port = 12345;

io.on('connection', function (socket)
{
    console.log('user connected');
    socket.on('disconnect', function ()
    {
        console.log('user disconnected');
    });

    socket.on('toServer message', function (msg)
    {
        console.log('message: ' + msg);
        io.sockets.emit('toClient message', msg);
    });
});

http.listen(port);
console.log('Server running on port ' + port);


//________________with different path______________________//

var io  = require('socket.io')(http, { path: '/myapp/socket.io'});

io
.of('/my-namespace')
.on('connection', function(socket){
    console.log('a user connected with id %s', socket.id);

    socket.on('my-message', function (data) {
        io.of('my-namespace').emit('my-message', data);
        // or socket.emit(...)
        console.log('broadcasting my-message', data);
    });
});