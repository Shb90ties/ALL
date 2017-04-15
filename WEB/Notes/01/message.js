sendMessage(messageData,chat,AT)
{
    var content = {};
    post('createMessage',{
        access_token : AT,
        chat_url : chat,
        type : messageData.type,
        content : messageData
    },function(){
        console.log('sent message');
    });
}


generateMessage(data,isBot)
{
    if( data.type == 'text' ) {
        var image = 'https://graph.facebook.com/' + data.facebookID + '/picture?width=500&height=500';
        var itemURL = '';
    } else {
        var image = data.itemImage;
        var itemURL = data.itemURL;
    }
    return {
        type : data.type,
        senderId : data.facebookID,
        action : '',
        user : {
            id : data.facebookID,
            name : data.first_name + ' ' + data.last_name,
            image_url : image,
            color : data.chat_color
        },
        className : 'Message',
        text : data.text,
        isBot : isBot,
        itemURL : itemURL
    }
}