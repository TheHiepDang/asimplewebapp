angular.module(
    'ServiceModelModule',
    []
).factory('ServiceModel', [
    function () {
        var _ROOT = 'api/starhub',

            _AUTHORIZE = _ROOT + '/authenticate',
            _AUTHORITIES_GET = _ROOT + '/checkAuth',

            _MAIN_HEADER_BASE = _ROOT + '/mainHeader',
            _MAIN_HEADER_WITH_PAGE_TYPE = _MAIN_HEADER_BASE + '/%PAGE_TYPE%',
            _MAIN_HEADER_SET = _MAIN_HEADER_BASE + '/setHeader',

            _MAIN_BANNER_BASE = _ROOT + '/mainBanner',
            _MAIN_BANNER_WITH_PAGE_TYPE = _MAIN_BANNER_BASE + '/%PAGE_TYPE%',
            _MAIN_BANNER_SET = _MAIN_BANNER_BASE + '/setBanner',

            _PAGE_BASE = _ROOT + '/page',
            _PAGE_WITH_PAGE_TYPE = _PAGE_BASE + '/%PAGE_TYPE%',
            _PAGE_FILE_UPLOAD = _PAGE_BASE + '/upload',

            _TILE_BASE = _ROOT + '/tile',
            _TILE_WITH_PAGE_TYPE = _TILE_BASE + '/%PAGE_TYPE%',
            _TILE_SET_TILE = _TILE_BASE + '/setTile',
            _LOGOUT = '/logout';

        return {
            SECURITY: {
                AUTHORIZE: _AUTHORIZE,
                AUTHORITIES_GET: _AUTHORITIES_GET,
                LOGOUT: _LOGOUT
            },
            MAIN_HEADER: {
                MAIN_HEADER_BASE: _MAIN_HEADER_BASE,
                MAIN_HEADER_WITH_PAGE_TYPE: _MAIN_HEADER_WITH_PAGE_TYPE,
                MAIN_HEADER_SET: _MAIN_HEADER_SET
            },
            MAIN_BANNER: {
                MAIN_BANNER_BASE: _MAIN_BANNER_BASE,
                MAIN_BANNER_WITH_PAGE_TYPE: _MAIN_BANNER_WITH_PAGE_TYPE,
                MAIN_BANNER_SET: _MAIN_BANNER_SET
            },
            PAGE: {
                PAGE_BASE: _PAGE_BASE,
                PAGE_WITH_PAGE_TYPE: _PAGE_WITH_PAGE_TYPE,
                PAGE_FILE_UPLOAD: _PAGE_FILE_UPLOAD
            },
            TILE: {
                TILE_BASE: _TILE_BASE,
                TILE_WITH_PAGE_TYPE: _TILE_WITH_PAGE_TYPE,
                TILE_SET_TILE: _TILE_SET_TILE
            }
        };
    }]);
