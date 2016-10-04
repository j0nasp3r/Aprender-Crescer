
myapp.controller('GrupoController', function GrupoController($scope, $http, GrupoFactory) {

  // $scope.dados = [{"idGrupo": 1, "tipoUsuario": 'F', "descricaoGrupo": "acesso restrito"}];

    $scope.buscaGrupos = function () {
        GrupoFactory.getGrupos($scope.callbackGrupos);
    }

    $scope.callbackGrupos = function (resposta) {
        $scope.dados = resposta.data;
    }
    
    $scope.editarGrupos = function () {
        $scope.editando = !$scope.editando;
    }

    $scope.cadastroGrupos = function (grupo) {
        GrupoFactory.setGrupos($scope.callbackCadastroGrupos, grupo);
    }

    $scope.callbackCadastroGrupos = function (resposta) {
        if (resposta.status != 200) {
            swal("Contas", "Conta Cadastrada com sucesso!", "error");
        } else {
            //alert("OK");
            swal("Grupo", "Grupo Cadastrado com sucesso!", "success");
            $scope.buscaGrupos();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.grupo.descricaoGrupo = "";
        $scope.grupo.tipoUsuario = "";
    }
});
