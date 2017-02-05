angular.module(
    'MobilePageModelModule',
    []
).factory(
    'MobilePageModel', [
        'MainHeaderModel',
        'MainBannerModel',
        'TileModel',
        function (MainHeaderModel, MainBannerModel, TileModel) {
            return {
                pageType: 'MOBILE',
                setMainHeader: function (data) {
                    MainHeaderModel.populateFromJSON(data);
                },
                getMainHeader: function () {
                    return MainHeaderModel.getJSONFromObject();
                },
                setMainBanner: function (data) {
                    MainBannerModel.populateFromJSON(data);
                },
                getMainBanner: function () {
                    return MainBannerModel.getJSONFromObject();
                },
                setTiles: function (data) {
                    TileModel.populateFromJSON(data);
                },
                getTiles: function () {
                    return TileModel.getJSONFromObject();
                },
                populateModelWithTemplateJson: function (data) {
                    if (data.hasOwnProperty('mainHeader') && data.hasOwnProperty('mainBanner') && data.hasOwnProperty('tiles')) {
                        MainHeaderModel.clear();
                        MainBannerModel.clear();
                        TileModel.clear();
                        MainHeaderModel.populateFromJSONTemplate(data.mainHeader);
                        MainBannerModel.populateFromJSON(data.mainBanner);
                        TileModel.populateFromJSON(data.tiles);
                    }
                }
            };
        }
    ]
);
