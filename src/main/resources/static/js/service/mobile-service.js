angular.module(
    'MobileServiceModule',
    []
).service(
    'MobileService',
    [
        '$http',
        'ServiceModel',
        'MobilePageModel',
        '$location',
        'UtilService',
        function ($http, ServiceModel, MobilePageModel, $location, UtilService) {
            return {
                url: function (uri, params) {
                    return UtilService.setURLParameters(uri, params);
                },
                getMainHeaderItems: function () {
                    return $http({
                        url: this.url(ServiceModel.MAIN_HEADER.MAIN_HEADER_BASE),
                        method: 'GET'
                    });
                },
                setMainHeaderItems: function (data) {
                    return $http({
                        url: this.url(ServiceModel.MAIN_HEADER.MAIN_HEADER_SET),
                        method: 'POST',
                        data: data
                    });
                },
                getMainBannerContent: function (type) {
                    return $http({
                        url: this.url(ServiceModel.MAIN_BANNER.MAIN_BANNER_WITH_PAGE_TYPE, [type]),
                        method: 'GET'
                    });
                },
                setMainBannerContent: function (data) {
                    return $http({
                        url: this.url(ServiceModel.MAIN_BANNER.MAIN_BANNER_SET),
                        method: 'POST',
                        data: data
                    });
                },
                getTilesWithPageType: function (type) {
                    return $http({
                        url: this.url(ServiceModel.TILE.TILE_WITH_PAGE_TYPE, [type]),
                        method: 'GET'
                    });
                },
                setTiles: function (data) {
                    return $http({
                        url: this.url(ServiceModel.TILE.TILE_SET_TILE),
                        method: 'POST',
                        data: data
                    });
                },
                getCurrentUserAuth: function () {
                    return $http({
                        url: this.url(ServiceModel.SECURITY.AUTHORITIES_GET),
                        method: 'GET'
                    });
                },
                fetchOnTemplateJson: function (filepath) {
                    return $http({
                        type: 'GET',
                        url: "http://localhost:8000/" + filepath
                    });
                }
            };
        }
    ]
);
