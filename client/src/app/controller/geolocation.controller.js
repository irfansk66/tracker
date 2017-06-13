(function(){

    'use strict';

    angular.module('plunker')
        .controller('geolocationController',geolocationController)


    geolocationController.$inject=['vehicleService','$scope'];

    function geolocationController(vehicleService,$scope){

        var geolocationVm = this;

        $scope.onFormSubmit = function (vin) {

            vehicleService.getGeolocationByVin(vin)
                .then(function(readings){
                    geolocationVm.readings=readings;



                    //maps

                    var locations = geolocationVm.readings;

                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 1,
                        //center: new google.maps.LatLng(-35.6905, -103.3701),
                        center: new google.maps.LatLng(locations[0].latitude, locations[0].longitude),
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    });

                    var infowindow = new google.maps.InfoWindow();

                    var marker, i;

                    for (i = 0; i < locations.length; i++) {
                        console.log(locations[i].latitude, locations[i].longitude);
                        marker = new google.maps.Marker({
                            position: new google.maps.LatLng(locations[i].latitude, locations[i].longitude),
                            map: map
                        });

                        google.maps.event.addListener(marker, 'click', (function(marker, i) {
                            return function() {
                                infowindow.setContent(locations[i].latitude, locations[i].longitude);
                                infowindow.open(map, marker);
                            }
                        })(marker, i));
                    }


                    //maps

                    console.log(locations);
                }, function(error){
                    console.log(error);
                });




        }

    }

})();