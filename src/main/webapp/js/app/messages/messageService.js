app.service("messageService", function ($http) {

    var _this = this;

    _this.findAll = function (receiverId) {
        var params = {
            receiverId: receiverId
        };
        return $http.get("/messages", {params: params}).then(function (response) {
            return response.data;
        })
    }
});
