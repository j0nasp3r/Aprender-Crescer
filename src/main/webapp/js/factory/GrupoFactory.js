
'use strict'

myapp.factory('GrupoFactory', ['$http', function($http){
    return {
        getGrupos: function(callBack){
            $http({"method":"GET", "url":"/AprenderCrescer/rest/grupo/getGrupos"}).then(function(resposta){
                callBack(resposta);
            });
        },
        setGrupos: function(callBack, grupo){
            $http({"method": "POST", "url": "/AprenderCrescer/rest/grupo/setgrupo","headers": {"Content-Type": "application/json"},
                "data" : grupo
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },
    };
}]);