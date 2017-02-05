angular.module(
    'UserContextModelModule',
    []
).factory(
    'UserContextModel', [
        function () {
            return {
                roles : [],
                clear: function () {
                    this.roles.length = 0;
                },
                hasRole: function (roleToCheck) {
                    var userHasRole = false;

                    if (this.roles && angular.isArray(this.roles) && this.roles.indexOf(roleToCheck) !== -1) {
                        userHasRole = true;
                    }

                    return userHasRole;
                },
                populateFromJSON: function (data) {
                    this.roles.length = 0;
                    if (data !== null) {
                        this.roles = data.slice(0);
                    }
                }
            };
        }
    ]
);
