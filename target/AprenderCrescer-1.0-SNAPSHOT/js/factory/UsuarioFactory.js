
'use strict'

myapp.factory('UsuarioFactory', ['$http', function($http){
    return {
        getUsuario: function(callBack){
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
        deleteUsuario: function(callBack, usuario){
            $http({"method": "DELETE", "url": "/AprenderCrescer/rest/usuario/deleteusuario/idusuario","headers": {"Content-Type": "application/json"},
                "data" : usuario
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },   
    };
}]);


