app.service('authService', function ($http) {

    var _this = this;

    _this.getCurrentUser = function () {
        return $http.get('api/users/current').then(function (response) {
            return response.data;
        });
    }
});
