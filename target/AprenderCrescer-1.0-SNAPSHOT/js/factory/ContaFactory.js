
'use strict'

myapp.factory('ContaFactory', ['$http', function($http){
    return {
        getContas: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/conta/getContas"}).then(function(resposta){
                callBack(resposta);
            });
        },
    };
}]);