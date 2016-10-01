
'use strict'

myapp.factory('UsuarioFactory', ['$http', function($http){
    return {
        getUsuarios: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/usuario/getusuarios"}).then(function(resposta){
                callBack(resposta);
            });
        },
        setUsuario: function(callback, usuario){
            $http({"method":"POST", "url":"/AprenderCrescer/rest/usuario/setusuario","headers": {"Content-Type": "application/json"},
                "data" : usuario
            }).then(function(resposta){
                callback(resposta);
            },function(resposta){
                callback(resposta);
            });
        },
    };
}]);


