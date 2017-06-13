(function(){

    'use strict';

    angular.module('plunker')
        .controller('VehicleDetailController',VehicleDetailController)


    VehicleDetailController.$inject=['vehicleService','$routeParams'];
    function VehicleDetailController(vehicleService, $routeParams){

        var vehicleDetailVm = this;

        vehicleService.getVehiclesByVin($routeParams.vin)
            .then(function(vehicle){
                vehicleDetailVm.vehicle=vehicle;

            }, function(error){
                console.log(error);
            })

    }

})();





