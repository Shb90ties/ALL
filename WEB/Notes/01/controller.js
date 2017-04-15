angular.module(appName + '.controllers').controller('ChatController', ChatController);

ChatController.$inject = ['$scope', 'UserService', '$timeout', 'MessagesService' , 'SocketIoService','APIHandler','$stateParams'];
function ChatController($scope, UserService, $timeout, MessagesService, SocketIoService,APIHandler,$stateParams) {
    /*
        functions for chatController
    */


    // if controller doesn't run before $state.go('chat',url); and gets url
    $scope.initChat = function(callBack_toPlugin) {
        __chat_url  = $stateParams.url;
        $scope.chatUrl = configObject.appDomain + '/#/newChat/' + __chat_url;
        $scope.userData = UserService.getUserFacebookProfile();

        APIHandler.post('getChatUsers',{
            access_token : $scope.userData.authResponse.accessToken,
            chat_url : __chat_url
        },function(users){
            if(!users) {
                console.log('cannot load chat'); return;
            }

            $scope.roomUsers = set_roomUsers(users);

            SocketIoService.addEventListener(vars.chatURL,function(message){
                if(message.type == 'newUser'){
                    console.log('users ',message);//??
                    $scope.roomUsers = set_roomUsers(message.users);
                } else {
                    var message = MessagesService.generateMessage(message.data,false);
                    updateChatWithMessage(message);
                }
            });

            callBack_toPlugin({
                status : 'chat is ready',
                color : $scope.userData.chatColor || '#000000'
            });

            APIHandler.post('getAllMessages',{
                access_token : $scope.userData.authResponse.accessToken,
                chat_url : __chat_url
            },function(messages){
                if(!messages) {
                    console.log('cannot load chat messages'); return;
                }

                $scope.messages = MessagesService.convertToChatMessagesArray(messages);
                $scope.scrollToChatBottom();
            });
        });
    }
}