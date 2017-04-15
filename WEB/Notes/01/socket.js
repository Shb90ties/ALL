var socket = null;
addEventListener (chat_url,callBack) {
    if(!socket) {
        socket = io(configObject.socketDomain);
    }
    var channel = 'chat_url_'+chat_url;
    socket.on(channel, callBack);
}