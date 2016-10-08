
'use strict'

myapp.factory('GrupoFactory', ['$http', function ($http) {
        return {
            getGrupo: function (callBack) {
                $http({"method": "GET", "url": "/AprenderCrescer/rest/grupo/getGrupos"}).then(function (resposta) {
                    callBack(resposta);
                });
            },
            setGrupo: function (callBack, grupo) {
                $http({"method": "POST", "url": "/AprenderCrescer/rest/grupo/setgrupo", "headers": {"Content-Type": "application/json"},
                    "data": grupo
                }).then(function (resposta) {
                    callBack(resposta);
                }, function (resposta) {
                    callBack(resposta);
                });
            },
            updateGrupo: function (callBack, grupo) {
                $http({"method": "POST", "url": "/AprenderCrescer/rest/grupo/updategrupo", "headers": {"Content-Type": "application/json"},
                    "data": grupo
                }).then(function (resposta) {
                    callBack(resposta);
                }, function (resposta) {
                    callBack(resposta);
                });
            },
        deleteGrupo: function(callBack, grupo){
            $http({"method": "DELETE", "url": "/AprenderCrescer/rest/grupo/deletegrupo/idgrupo","headers": {"Content-Type": "application/json"},
                "data" : grupo
            }).then(function(resposta){
                callBack(resposta);
            },function(resposta){
                callBack(resposta);
            });
        },   
    };
}]);