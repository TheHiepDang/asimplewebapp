'use strict';
describe('Testing MobilePageController', function () {
    var $controller,
        controllerToTest,
        $httpBackend,
        $scope,
        serviceModel,
        mobilePageModel,
        mobileService,
        mainHeaderModel,
        mainBannerModel,
        tileModel,
        userContextModel,
        sharedService,

        pageType = 'MOBILE';

    beforeEach(module(
        'MobilePageControllerModule',
        'ServiceModelModule',
        'MobilePageModelModule',
        'UtilServiceModule',
        'MobileServiceModule',
        'MainHeaderModelModule',
        'MainBannerModelModule',
        'TileModelModule',
        'UserContextModelModule',
        'SharedServiceModule'));

    beforeEach(inject(function (_$httpBackend_,
                                _$controller_,
                                _$rootScope_,
                                ServiceModel,
                                MobilePageModel,
                                MobileService,
                                MainHeaderModel,
                                MainBannerModel,
                                TileModel,
                                UserContextModel,
                                SharedService) {
        $controller = _$controller_;
        //$controller = _$controller_("MobilePageController", {$scope:$scope });
        $scope = _$rootScope_.$new();
        $httpBackend = _$httpBackend_;

        serviceModel = ServiceModel;
        mobilePageModel = MobilePageModel;
        mobileService = MobileService;
        mainHeaderModel = MainHeaderModel;
        mainBannerModel = MainBannerModel;
        tileModel = TileModel;
        userContextModel = UserContextModel;
        sharedService = SharedService;

        setUpServiceResponses();
    }));

    function createControllerToTest() {
        controllerToTest = $controller('MobilePageController', {
            $scope: $scope,
            ServiceModel: serviceModel,
            MobilePageModel: mobilePageModel,
            MobileService: mobileService,
            MainHeaderModel: mainHeaderModel,
            MainBannerModel: mainBannerModel,
            TileModel: tileModel,
            UserContextModel: userContextModel,
            SharedService: sharedService

        });
    }

    function setUpServiceResponses() {
        $httpBackend.when('GET', mobileService.url(serviceModel.MAIN_HEADER.MAIN_HEADER_BASE)).respond([]);
        $httpBackend.when('GET', mobileService.url(serviceModel.MAIN_BANNER.MAIN_BANNER_WITH_PAGE_TYPE, [pageType])).respond([]);
        $httpBackend.when('GET', mobileService.url(serviceModel.TILE.TILE_WITH_PAGE_TYPE, [pageType])).respond([]);
    }

    function verifyServiceRequests() {
        $httpBackend.flush();
        $httpBackend.verifyNoOutstandingRequest();
        $httpBackend.verifyNoOutstandingExpectation();
    }

    it('should call correct service on creation', function () {
        createControllerToTest();
        verifyServiceRequests();
    });

    describe('Testing controller instantiation', function () {
        it('Calling correct services', function () {
            createControllerToTest();
            verifyServiceRequests();
        });
    });

    describe('Testing controller methods', function () {
        beforeEach(function () {
            createControllerToTest();
            $httpBackend.flush();
        });

        describe('Testing canShow', function () {
            describe('#isAdmin', function () {
                it('should be true when user role is ADMIN', function () {
                    userContextModel.roles = ['ROLE_ADMIN'];
                    expect($scope.canShow.isAdmin()).toBe(true);
                });
                it('should be false when user role is undefined or anything else beside ADMIN', function () {
                    expect($scope.canShow.isAdmin()).toBe(false);
                    userContextModel.roles = ['ROLE_USER'];
                    expect($scope.canShow.isAdmin()).toBe(false);
                });
            });

            describe('#templateMode', function () {
                it('should be true when one of the model is dirty', function () {
                    mainHeaderModel.markDirty();
                    expect($scope.canShow.templateMode()).toBe(true);
                });
                it('should be false when none of the model is marked dirty', function () {
                    expect($scope.canShow.templateMode()).toBe(false);
                });
            });
        });

    });
});