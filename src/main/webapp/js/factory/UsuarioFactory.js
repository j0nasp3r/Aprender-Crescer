
'use strict'

myapp.factory('UsuarioFactory', ['$http', function($http){
    return {
        getUsuarios: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/usuario/getusuarios"}).then(function(resposta){
                callBack(resposta);
            });
        },
        setUsuario: function(callBack, usuario){
            $http({"method": "POST", "url": "/AprenderCrescer/rest/usuario/setusuario","headers": {"Content-Type": "application/json"},
                "data" : usuario
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },
        updateUsuario: function(callBack, usuario){
            $http({"method": "POST", "url": "/AprenderCrescer/rest/usuario/updateusuario","headers": {"Content-Type": "application/json"},
                "data" : usuario
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },
        deleteUsuario: function(callBack, id){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/usuario/deleteusuario/"+id}).then(function(resposta){
                callBack(resposta);
            });
        },
    };
}]);


