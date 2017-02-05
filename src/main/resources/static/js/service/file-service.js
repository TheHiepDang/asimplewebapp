angular.module(
    'FileServiceModule',
    []
).factory(
    'FileService',
    [
        '$http',
        'ServiceModel',
        'UtilService',
        function ($http, ServiceModel, UtilService) {
            return {
                url: function (uri, params) {
                    return UtilService.setURLParameters(uri, params);
                },
                upload: function (file) {
                    var fd = new FormData();
                    fd.append('file', file);
                    return $http({
                        url: this.url(ServiceModel.PAGE.PAGE_FILE_UPLOAD),
                        method: 'POST',
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined},
                        data: fd
                    });
                }
            }
        }
    ]
);
