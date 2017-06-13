(function(){

    'use strict';

    angular.module('plunker')
        .controller('HistoricalAlertsController',HistoricalAlertsController)


    HistoricalAlertsController.$inject=['vehicleService','$scope'];

    function HistoricalAlertsController(vehicleService,$scope){

        var historicalAlertsVm = this;

        $scope.onFormSubmit = function (vin) {

            vehicleService.getAlertsByVin(vin)
                .then(function(alerts){
                    historicalAlertsVm.alerts=alerts;

                }, function(error){
                    console.log(error);
                });
        }

    }

})();
