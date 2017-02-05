angular.module(
    'MainBannerModelModule',
    []
).factory(
    'MainBannerModel', [
        function () {
            return {
                title: null,
                description: null,
                backgroundIMGURL: null,
                ctatext: null,
                ctaurl: null,
                dirty: false,
                markDirty: function () {
                    this.dirty = true;
                },
                cleanse: function () {
                    this.dirty = false;
                },
                isDirty: function () {
                    return this.dirty;
                },
                clear: function () {
                    this.title = null;
                    this.description = null;
                    this.backgroundIMGURL = null;
                    this.ctatext = null;
                    this.ctaurl = null;
                    this.dirty = false;
                },
                getJSONFromObject: function () {
                    var json = {};
                    json.title = this.title;
                    json.description = this.description;
                    json.backgroundIMGURL = this.backgroundIMGURL;
                    json.ctatext = this.ctatext;
                    json.ctaurl = this.ctaurl;
                    return json;
                },
                populateFromJSON: function (data) {
                    if (data !== null) {
                        this.title = data.title;
                        this.description = data.description;
                        this.backgroundIMGURL = data.backgroundIMGURL;
                        this.ctatext = data.ctatext;
                        this.ctaurl = data.ctaurl;
                    }
                }
            };
        }
    ]
);
