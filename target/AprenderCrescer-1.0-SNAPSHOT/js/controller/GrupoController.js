
myapp.controller('GrupoController', function GrupoController($scope, $http, GrupoFactory) {

    $scope.dados = [{"idGrupo": 1, "tipoUsuario":'F', "descricaoGrupo": "acesso restrito"}];

    $scope.buscaGrupos = function () {
        GrupoFactory.getGrupos($scope.callbackGrupos);
    }

    $scope.callbackGrupos = function (resposta) {
        $scope.dados = resposta.data;
    }
});
