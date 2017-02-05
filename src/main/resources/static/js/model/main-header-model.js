angular.module(
    'MainHeaderModelModule',
    []
).factory(
    'MainHeaderModel', [
        function () {
            return {
                url1: null,
                url2: null,
                url3: null,
                url4: null,
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
                    this.url1 = null;
                    this.url2 = null;
                    this.url3 = null;
                    this.url4 = null;
                    this.dirty = false;
                },
                getJSONFromObject: function () {
                    var json = {};
                    json.url1 = this.url1;
                    json.url2 = this.url2;
                    json.url3 = this.url3;
                    json.url4 = this.url4;

                    return json;
                },
                populateFromJSON: function (data) {
                    if (data !== null) {
                        this.url1 = data[0].url;
                        this.url2 = data[1].url;
                        this.url3 = data[2].url;
                        this.url4 = data[3].url;
                    }
                },
                populateFromJSONTemplate: function (data) {
                    if (data !== null) {
                        this.url1 = data.url1;
                        this.url2 = data.url2;
                        this.url3 = data.url3;
                        this.url4 = data.url4;
                    }
                },
                getDTO: function () {
                    var data = [];
                    var first = {'id': null, 'url': this.url1};
                    var second = {'id': null, 'url': this.url2};
                    var third = {'id': null, 'url': this.url3};
                    var fourth = {'id': null, 'url': this.url4};
                    data.push(first, second, third, fourth);
                    return data;
                }
            };
        }
    ]
);
