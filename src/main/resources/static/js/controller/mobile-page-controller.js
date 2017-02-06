var mobileApp = angular.module(
    'MobilePageControllerModule',
    []
);
mobileApp.directive('starhubFile', ['FileService', 'SharedService', function (FileService, SharedService) {
    return {
        restrict: 'A',
        link: function (scope, element) {
            element.bind('change', function () {
                scope.$apply(function () {
                    FileService.upload(element[0].files[0]).then(
                        function successHandler(successResponse) {
                            SharedService.newTemplateEvent(successResponse.data);
                            SharedService.broadCast();
                            console.log('Uploaded successfully file with name: ' + successResponse.data);
                            //element.val(null);
                        })

                });
            });
        }
    };
}]);
mobileApp.config(['$compileProvider', function ($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|tel|file|data|blob):/);
}]);
mobileApp.controller(
    'MobilePageController',
    [
        '$rootScope',
        '$scope',
        'ServiceModel',
        'MobilePageModel',
        'MobileService',
        'MainHeaderModel',
        'MainBannerModel',
        'TileModel',
        'UserContextModel',
        'SharedService',
        function ($rootScope, $scope, ServiceModel, MobilePageModel, MobileService, MainHeaderModel, MainBannerModel, TileModel, UserContextModel, SharedService) {
            $scope.mainHeaderModel = MainHeaderModel;
            $scope.mainBannerModel = MainBannerModel;
            $scope.tilesModel = TileModel;
            function initialise() {
                _loadMainHeaderItems();
                _loadMainBanner();
                _loadTiles();
            }

            $scope.$on('newTemplateBroadcast', function () {
                MobileService.fetchOnTemplateJson(SharedService.fileName).then(
                    function successHandler(successResponse) {
                        MobilePageModel.populateModelWithTemplateJson(successResponse.data);
                        $scope.mainHeaderModel.markDirty();
                        $scope.mainBannerModel.markDirty();
                        $scope.tilesModel.markDirty();
                    }
                );
            });

            function _loadMainHeaderItems() {
                return MobileService.getMainHeaderItems().then(
                    function successHandler(successResponse) {
                        if (successResponse.data.length)
                            MobilePageModel.setMainHeader(successResponse.data);
                    },
                    function errorHandler(errorResponse) {

                    }
                );
            }

            function _loadMainBanner() {
                return MobileService.getMainBannerContent(MobilePageModel.pageType).then(
                    function successHandler(successResponse) {
                        if (successResponse.data !== 'unidefined')
                            MobilePageModel.setMainBanner(successResponse.data);
                    },
                    function errorHandler(errorResponse) {

                    }
                );
            }

            function _loadTiles() {
                return MobileService.getTilesWithPageType(MobilePageModel.pageType).then(
                    function successHandler(successResponse) {
                        if (successResponse.data.length)
                            MobilePageModel.setTiles(successResponse.data);
                    },
                    function errorHandler(errorResponse) {

                    }
                );
            }

            function _saveMainHeaderTemplate() {
                return MobileService.setMainHeaderItems($scope.mainHeaderModel.getDTO()).then(
                    function successHandler() {
                        _loadMainHeaderItems();
                        $scope.mainHeaderModel.cleanse();
                    }
                );
            }

            function _discardMainHeaderTemplate() {
                _loadMainHeaderItems();
                $scope.mainHeaderModel.cleanse();
            }

            function _saveMainBannerTemplate() {
                return MobileService.setMainBannerContent($scope.mainBannerModel).then(
                    function successHandler() {
                        _loadMainBanner();
                        $scope.mainBannerModel.cleanse();
                    }
                );
            }

            function _discardMainBannerTemplate() {
                _loadMainBanner();
                $scope.mainBannerModel.cleanse();
            }

            function _saveTilesTemplate() {
                return MobileService.setTiles($scope.tilesModel.getDTO()).then(
                    function successHandler() {
                        _loadTiles();
                        $scope.tilesModel.cleanse();
                    }
                );
            }

            function _discardTilesTemplate() {
                _loadTiles();
                $scope.tilesModel.cleanse();
            }

            $scope.encodeJson = function () {
                return encodeURIComponent("{\"mainHeader\"" + ":" + JSON.stringify($scope.mainHeaderModel.getJSONFromObject(), null, "    ") + ","
                    + "\"mainBanner\"" + ":" + JSON.stringify($scope.mainBannerModel.getJSONFromObject(), null, "    ") + ","
                    + "\"tiles\"" + ":" + JSON.stringify($scope.tilesModel.getJSONFromObject(), null, "    ") + "}");
            };

            $scope.clickHandler = {
                saveMainHeaderTemplate: _saveMainHeaderTemplate,
                discardMainHeaderTemplate: _discardMainHeaderTemplate,
                saveMainBannerTemplate: _saveMainBannerTemplate,
                discardMainBannerTemplate: _discardMainBannerTemplate,
                saveTilesTemplate: _saveTilesTemplate,
                discardTilesTemplate: _discardTilesTemplate,
                saveTemplate: function () {
                    if ($scope.mainHeaderModel.isDirty()) {
                        _saveMainHeaderTemplate();
                    }
                    if ($scope.mainBannerModel.isDirty()) {
                        _saveMainBannerTemplate();
                    }
                    if ($scope.tilesModel.isDirty()) {
                        _saveTilesTemplate();
                    }
                }
            };

            $scope.canShow = {
                isAdmin: function () {
                    return UserContextModel.hasRole('ROLE_ADMIN');
                },
                templateMode: function () {
                    return $scope.mainHeaderModel.isDirty() ||
                        $scope.mainBannerModel.isDirty() ||
                        $scope.tilesModel.isDirty();
                }
            };

            initialise();
        }
    ]
);