app.controller('appCtrl', function ($scope, userService, messageService) {

    $scope.users = {};
    $scope.messages = {};
    $scope.selected = false;
    $scope.findAllUser = function () {
        userService.findAll().then(function (response) {
            $scope.users = response;
        });
    };

    $scope.findAllMessage = function (user) {
        window.localStorage.setItem("receiverId", user.id);
        $scope.selected = true;
        if (user !== undefined) {
            messageService.findAll(user.id).then(function (response) {
                $scope.messages = response;
                console.log(response);
            });
        }
    };

    $scope.findAllUser();

    var stompClient = null;

    stompClient = Stomp.over(new SockJS('/connect'));
    stompClient.debug = null;
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/aaa', function (response) {
            alert(response);
        });

        stompClient.subscribe("/user/queue/private", function (response) {
            // $scope.messages.push(response.body);
            alert(response.body);
        })
    });

    $scope.sendMessage = function () {
        var message = document.getElementById('message').value;
        var receiverId = window.localStorage.getItem("receiverId");
        stompClient.send("/app/message", {}, JSON.stringify({'text': message, 'receiverId': receiverId}));
    };

});
