(function(){
    'use strict';

    angular.module('plunker',['ngRoute','ngMessages','zingchart-angularjs']);

    angular.module('plunker')
        .config(moduleConfig);

    moduleConfig.$inject= ['$routeProvider'];

    function moduleConfig($routeProvider){

        $routeProvider
            .when('/vehicles',{
                templateUrl:'app/views/vehicle-list.tmpl.html',
                controller: 'VehicleListController',
                controllerAs: 'vehicleListVm'

            })
            .when('/vehicles/:vin',{
                templateUrl:'app/views/vehicle-detail.tmpl.html',
                controller: 'VehicleDetailController',
                controllerAs: 'vehicleDetailVm'

            })
            .when('/Historical-Alerts',{
                templateUrl:'app/views/Historical-Alerts.tmpl.html',
                controller: 'HistoricalAlertsController',
                controllerAs: 'historicalAlertsVm'

            })
            .when('/High-Alerts',{
                templateUrl:'app/views/High-Alerts.tmpl.html',
                controller: 'HighAlertsController',
                controllerAs: 'highAlertsVm'

            })
            .when('/Geolocation',{
                templateUrl:'app/views/geolocation.tmpl.html',
                controller: 'geolocationController',
                controllerAs: 'geolocationVm'

            })
            .when('/Plot-Signals',{
                templateUrl:'app/views/plot-signal.tmpl.html',
                controller: 'plotSignalController',
                controllerAs: 'plotSignalVm'

            })
            .otherwise({
                redirectTo:'/vehicles'

            })

    }

})();