
'use strict'

myapp.factory('UsuarioFactory', ['$http', function($http){
    return {
        getUsuarios: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/usuario/getusuarios"}).then(function(resposta){
                callBack(resposta);
            });
        },
    };
}]);


