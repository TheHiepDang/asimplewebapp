angular.module(
    'UtilServiceModule',
    []
).factory(
    'UtilService',
    [
        '$log',
        'ServiceModel',
        '$http',
        function ($log, ServiceModel, $http) {
            return {
                logout: function () {
                    return $http({
                        url: this.setURLParameters(ServiceModel.SECURITY.LOGOUT),
                        method: 'GET'
                    });
                },
                setURLParameters: function (uri, params) {
                    var placeholderRegExp = /(%[A-Z_]+%)/g,
                        placeholders = uri.match(placeholderRegExp);

                    if (uri === null || angular.isUndefined(uri)) {
                        $log.error('URI is null or undefined');
                    }

                    if (placeholders !== null && angular.isArray(params) && placeholders.length === params.length) {
                        for (var i = 0; i < placeholders.length; i += 1) {
                            uri = uri.replace(placeholders[i], params[i]);
                        }

                        return uri;
                    } else if (placeholders === null) {
                        if (angular.isArray(params) && params.length > 0) {
                            $log.debug('URI contains no placeholder but you tried to set some');
                        }

                        return uri;
                    } else if (placeholders !== null && angular.isArray(params) && params.length === 0) {
                        $log.error('URI contains one or more placeholders but you have not provided any parameters');
                    } else {
                        $log.error('setURLParameters(): unspecified error; placeholders:', placeholders, 'params:', params);
                    }
                }
            };
        }
    ]
);
