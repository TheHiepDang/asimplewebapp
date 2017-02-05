angular.module(
    'AppPagesModule',
    [
        /*Controller*/
        'AllPagesControllerModule',
        'MobilePageControllerModule',

        /*Models*/
        'MobilePageModelModule',
        'ServiceModelModule',
        'MainHeaderModelModule',
        'MainBannerModelModule',
        'TileModelModule',
        'UserContextModelModule',
        'FileServiceModule',
        'SharedServiceModule',

        /*Services*/
        'MobileServiceModule',
        'UtilServiceModule'
    ]
);
