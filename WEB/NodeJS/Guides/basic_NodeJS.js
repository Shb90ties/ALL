var express = require('express');
var app = express();
var port = process.env.PORT || 1337;

var io = require('socket.io').listen(app.listen(port));
console.log('Running on port ' + port);


app.get('/', function (req, res, next)
{			// example localhost:1337/?command=Connection&OtherParameters
    if (!req.query.command) {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(index); next(); return;
    }
    var answer = new Object();
    switch (req.query.command) {
        case 'Connection':
            res.send('Connected!!'); next(); break;
        case 'OwnerLogin':
			function(args); next(); break;
			.....
			....
			...
    }
});

io.on('connection', function (socket) {
    console.log('new user');

    socket.on('disconnect', function () {
        console.log('user been dissconnected');
    });
    socket.on('forceDisconnect', function () { socket.disconnect(); });

    socket.on('Server', function (msg) {
        console.log(msg);
        io.emit('Client', 'From server');
    });

	.....
	....
	..
});