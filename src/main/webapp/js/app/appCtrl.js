app.controller('appCtrl', function ($scope, userService, messageService) {

    $scope.users = {};
    $scope.messages = {};
    $scope.findAllUser = function () {
        userService.findAll().then(function (response) {
            $scope.users = response;
            console.log(response);
        });
    };

    $scope.findAllMessage = function (user) {
        if (user !== undefined) {
            messageService.findAll(user.id).then(function (response) {
                $scope.messages = response;
                console.log(response);
            });
        }
    };

    $scope.findAllUser();
    $scope.findAllMessage();

    var stompClient = null;

    stompClient = Stomp.over(new SockJS('/connect'));
    stompClient.debug = null;
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/aaa', function (response) {
            console.log(response);
            alert(response);
        });

        stompClient.subscribe("/user/queue/private", function (response) {
            console.log(response);
            $scope.messages.push(response.body);
            alert(response.body);
        })
    });

    $scope.sendMessage = function () {
        var message = document.getElementById('message').value;
        stompClient.send("/app/message", {}, JSON.stringify({'text': message, 'receiverId': 2}));
    };

});
