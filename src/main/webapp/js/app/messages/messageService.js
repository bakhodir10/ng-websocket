app.service("messageService", function ($http) {

    var _this = this;

    _this.findAll = function (receiverId) {
        return $http.get("api/users/messages/" + receiverId).then(function (response) {
            return response.data;
        })
    }
});
