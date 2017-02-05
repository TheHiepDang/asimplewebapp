angular.module(
    'TileModelModule',
    []
).factory(
    'TileModel', [
        function () {
            return {
                tiles: [],
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
                    this.tiles.length = 0;
                    this.dirty = false;
                },
                getJSONFromObject: function () {
                    return this.tiles[0];
                },
                populateFromJSON: function (data) {
                    this.tiles.length = 0;
                    if (data) {
                        if(data[0].subtitles_2) {
                            this.tiles.push(data);
                        }else {
                            this.tiles.push([data[1],data[0]]);
                        }
                    }
                },
                getDTO: function () {
                    return this.tiles[0];
                }
            };
        }
    ]
);
