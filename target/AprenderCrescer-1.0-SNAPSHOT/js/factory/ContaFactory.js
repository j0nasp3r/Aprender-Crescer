
'use strict'

myapp.factory('ContaFactory', ['$http', function ($http) {
        return {
            getConta: function (callBack) {
                $http({"method": "GET", "url": "/AprenderCrescer/rest/conta/getContas"}).then(function (resposta) {
                    callBack(resposta);
                });
            },
            setConta: function (callBack, conta) {
                $http({"method": "POST", "url": "/AprenderCrescer/rest/conta/setconta", "headers": {"Content-Type": "application/json"},
                    "data": conta
                }).then(function (resposta) {
                    callBack(resposta);
                }, function (resposta) {
                    callBack(resposta);
                });
            },
            updateConta: function (callBack, conta) {
                $http({"method": "POST", "url": "/AprenderCrescer/rest/conta/updateconta", "headers": {"Content-Type": "application/json"},
                    "data": conta
                }).then(function (resposta) {
                    callBack(resposta);
                }, function (resposta) {
                    callBack(resposta);
                });
            },
         deleteConta: function(callBack, conta){
            $http({"method": "DELETE", "url": "/AprenderCrescer/rest/conta/deleteconta/idconta","headers": {"Content-Type": "application/json"},
                "data" : conta
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },   
    };
}]);