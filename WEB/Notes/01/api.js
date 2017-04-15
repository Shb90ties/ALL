var post = function(path,parameters,callBack){
    var error_function = error_callBack || default_error_function;
    var address = configObject.apiDomain + path;
    $http.post(address,parameters)
        .then(function success(response) {
            if(response.data) {
                callBack(response.data);
            } else {
                console.log('error, result',response);
                console.log('details, address : ',address,parameters);
                callBack(0);
            }
        }, function error(error) {
            console.log('error, connecting to server',error);
            console.log('details, address : ',address,parameters);
            callBack(0);
        });
};


post('login',{
    access_token : var,
    chat_url : localStorage.getItem('..') || ''
}, function(result){
    if(!result || !result.data.status) {
        responseNewUser(resolve);
    } else {
        //.....
    }
});


post('createMessage',{
    access_token : .... ,
    chat_url : .... ,
    type : ..... ,
    content : {
        //according to type
    }
},function(){ console.log('message sent'); })
