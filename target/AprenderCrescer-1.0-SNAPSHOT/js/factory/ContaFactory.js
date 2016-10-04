
'use strict'

myapp.factory('ContaFactory', ['$http', function($http){
    return {
        getContas: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/conta/getContas"}).then(function(resposta){
                callBack(resposta);
            });
        },
        setContas: function(callBack, conta){
            $http({"method": "POST", "url": "/AprenderCrescer/rest/conta/setconta","headers": {"Content-Type": "application/json"},
                "data" : conta
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },
    };
}]);