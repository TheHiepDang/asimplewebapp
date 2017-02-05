/* global angular */

var app = angular.module(
    'starhubApp',
    [
        'AppPagesModule',
        'AppLibrariesModule'
    ]
);
app.config(
    [
        '$routeProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/api/starhub/mobile', {
                    templateUrl: '/view/pages/mobile/mobilePage.html',
                    controller: 'AllPagesController'
                })
                .otherwise(
                    {redirectTo: '/api/starhub/mobile'}
                );
        }
    ]
);
