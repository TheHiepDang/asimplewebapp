angular.module(
    'SharedServiceModule',
    []
).factory(
    'SharedService',
    [
        '$rootScope',
        function ($rootScope) {
            var sharedService = {};
            sharedService.newTemplateDetected = false;
            sharedService.newTemplateEvent = function (fileName) {
                this.newTemplateDetected = true;
                sharedService.fileName = fileName;
            };
            sharedService.broadCast = function () {
                if (this.newTemplateDetected)
                    $rootScope.$broadcast('newTemplateBroadcast');
            };
            return sharedService;
        }
    ]
);
