app.service('userService', function ($http) {

    var _this = this;

    _this.findAll = function () {
        return $http.get('api/users').then(function (response) {
            return response.data;
        });
    }
});
