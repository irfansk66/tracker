(function(){

    'use strict';

    angular.module('plunker')
        .controller('VehicleListController',VehicleListController)


    VehicleListController.$inject=['vehicleService'];
    function VehicleListController(vehicleService){

        var vehicleListVm = this;

        vehicleService.getVehicles()
            .then(function(vehicles){
                vehicleListVm.vehicles=vehicles;

            },function(error)
            {
                console.log(error);
            });

        vehicleListVm.sorter={
            sortBy:'lastServiceDate',
            sortOrder:true
        };

    }

})();