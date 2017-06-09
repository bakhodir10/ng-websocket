app.controller('userAddCtrl', function ($scope, $uibModalInstance) {
        console.log('modal');

        $scope.user = {};

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});
