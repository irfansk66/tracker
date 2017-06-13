(function(){

    'use strict';

    angular.module('plunker')
        .controller('plotSignalController',plotSignalController)


    plotSignalController.$inject=['vehicleService','$scope'];

    function plotSignalController(vehicleService,$scope){

        var plotSignalVm = this;

        $scope.onFormSubmit = function (vin,tx) {

            vehicleService.getPlotSignals(vin,tx)
                .then(function(readings){
                    plotSignalVm.readings=readings;
                    console.log(plotSignalVm.readings);

                    //plot
                    var i ;
                    var fuelReadings =[];
                    for(i=0;i<plotSignalVm.readings.length;i++)
                    {
                        fuelReadings.push(plotSignalVm.readings[i].fuelVolume);

                    }
                    console.log(fuelReadings);
                    $scope.myJson = {
                        title: {
                            text: "Fuel Volume in the specified Time Range",
                            fontSize: 16,
                            fontColor: "#fff"
                        },
                        backgroundColor: "#2bbb9a",
                        globals: {
                            shadow: false,
                            fontFamily: "Arial"
                        },
                        type: "line",
                        scaleX: {
                            maxItems: 8,
                            lineColor: "white",
                            lineWidth: "1px",
                            tick: {
                                lineColor: "white",
                                lineWidth: "1px"
                            },
                            item: {
                                fontColor: "white"
                            },
                            guide: {
                                visible: false
                            }
                        },
                        scaleY: {
                            lineColor: "white",
                            lineWidth: "1px",
                            tick: {
                                lineColor: "white",
                                lineWidth: "1px"
                            },
                            guide: {
                                lineStyle: "solid",
                                lineColor: "#249178"
                            },
                            item: {
                                fontColor: "white"
                            },
                        },
                        tooltip: {
                            visible: false
                        },
                        crosshairX: {
                            lineColor: "#fff",
                            scaleLabel: {
                                backgroundColor: "#fff",
                                fontColor: "#323232"
                            },
                            plotLabel: {
                                backgroundColor: "#fff",
                                fontColor: "#323232",
                                text: "%v",
                                borderColor: "transparent"
                            }
                        },
                        plot: {
                            lineWidth: "2px",
                            lineColor: "#FFF",
                            aspect: "spline",
                            marker: {
                                visible: false
                            }
                        },
                        series: [{
                            values: fuelReadings
                        }]
                    };

                    //plot

                }, function(error){
                    console.log(error);
                });

        }

    }

})();