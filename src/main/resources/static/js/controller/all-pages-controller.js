angular.module(
    'AllPagesControllerModule',
    []
).controller(
    'AllPagesController',
    [
        '$rootScope',
        '$scope',
        'UserContextModel',
        'UtilService',
        'MobileService',
        function ($rootScope, $scope, UserContextModel, UtilService, MobileService) {

            loadCurrentUserAuth();

            function loadCurrentUserAuth() {
                return MobileService.getCurrentUserAuth().then(
                    function successHandler(successResponse) {
                        UserContextModel.populateFromJSON(successResponse.data);
                    }
                );
            }

            $scope.clickHandler = {
                logout: function () {
                    UtilService.logout().then(
                        MobileService.getCurrentUserAuth().then(
                            function successHandler(successResponse) {
                                UserContextModel.populateFromJSON(successResponse.data);
                            }
                        )
                    );
                }
            };

            $scope.canShow = {
                isAdmin: function () {
                    return UserContextModel.hasRole('ROLE_ADMIN');
                }
            };
        }
    ]
);