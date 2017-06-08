app.controller('appCtrl', function ($scope, userService, $uibModal, messageService, authService) {

    $scope.visible = false;
    $scope.users = {};
    $scope.messages = {};
    $scope.activeUser = null;
    $scope.selected = false;

    $scope.getCurrentUser = function () {
        authService.getCurrentUser().then(function (res) {
            console.log(res);
        })
    };

    $scope.getCurrentUser();

    $scope.findAllUser = function () {
        userService.findAll().then(function (response) {
            $scope.users = response;
        });
    };

    $scope.findAllMessage = function (id) {
        window.localStorage.setItem("receiverId", id);
        $scope.activeId = id;
        $scope.selected = true;
            messageService.findAll(id).then(function (response) {
                $scope.messages = response;
                console.log(response);
            });
    };

    $scope.init = function () {
        var id = window.localStorage.getItem('receiverId');
        if(id){
           $scope.findAllMessage(id);
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


    $scope.add = function () {
        $uibModal.open({
            animation: true,
            templateUrl: '/js/app/users/add/user.add.component.html',
            controller: 'userAddCtrl'
        });
    }
});
