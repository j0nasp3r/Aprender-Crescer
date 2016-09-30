
'use strict'

myapp.factory('GrupoFactory', ['$http', function($http){
    return {
        getGrupos: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/grupo/getGrupos"}).then(function(resposta){
                callBack(resposta);
            });
        },
    };
}]);
