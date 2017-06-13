(function(){

    'use strict';

    angular.module('plunker')
        .controller('HighAlertsController',HighAlertsController)


    HighAlertsController.$inject=['vehicleService'];
    function HighAlertsController(vehicleService){

        var highAlertsVm = this;

        vehicleService.getHighAlerts()
            .then(function(alerts){
                highAlertsVm.alerts=alerts;

            },function(error)
            {
                console.log(error);
            });

        highAlertsVm.sorter={
            sortBy:'highAlertsVm.alerts[2]',
            sortOrder:true
        };

    }

})();