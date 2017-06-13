(function(){
    'use strict';

    angular.module('plunker')
        .service('vehicleService',vehicleService);


    vehicleService.$inject = ['$q','$http'];

    function vehicleService($q,$http){
        var self=this;

        self.getVehicles=getVehicles;
        self.getVehiclesByVin=getVehiclesByVin;
        self.getAlertsByVin=getAlertsByVin;
        self.getHighAlerts=getHighAlerts;
        self.getGeolocationByVin=getGeolocationByVin;
        self.getPlotSignals=getPlotSignals;

        function getVehicles(){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/vehicles')
                .then(successFn,errorFn);

        }

        function getVehiclesByVin(vin){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/vehicles/'+vin)
                .then(successFn,errorFn);
        }

        function getAlertsByVin(vin){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/alerts/'+vin)
                .then(successFn,errorFn);
        }

        function getHighAlerts(){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/alerts')
                .then(successFn,errorFn);
        }
        function getGeolocationByVin(vin){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/readings/'+vin)
                .then(successFn,errorFn);
        }
        function getPlotSignals(vin,tx){
            return  $http.get('http://localhost:8082/MAvenSpringapi/api/readings/'+vin+'/'+tx)
                .then(successFn,errorFn);
        }




        function successFn(response){
            console.log(response.data);
            return response.data;

        }

        function errorFn(error){
            return $q.reject(error);
        }
    }

})();