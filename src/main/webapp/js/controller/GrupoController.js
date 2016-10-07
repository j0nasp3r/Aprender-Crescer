
myapp.controller('GrupoController', function GrupoController($scope, $http, GrupoFactory) {

    // $scope.dados = [{"idGrupo": 1, "tipoUsuario": 'F', "descricaoGrupo": "acesso restrito"}];

    $scope.buscaGrupo = function () {
        GrupoFactory.getGrupo($scope.callbackGrupo);
    }

    $scope.callbackGrupo = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarGrupo = function (item) {
        $scope.editando = true;
        $scope.grupo = angular.copy(item);
    }

    $scope.cadastroGrupo = function (grupo) {
        if (grupo.idGrupo && grupo.idGrupo != 0) {
            GrupoFactory.updateGrupo($scope.callbackCadastroGrupo, grupo);
        } else {
            GrupoFactory.setGrupo($scope.callbackCadastroGrupo, grupo);
        }

    }

    $scope.callbackCadastroGrupo = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Grupo", "Erro ao atualizar o cadastro de grupo!", "error");
            } else {
                swal("Grupo", "Erro ao cadastrar o grupo!", "error");
            }
        } else {
            if ($scope.editando == true) {
                swal("Grupo", "Grupo salvo com sucesso!", "success");
            } else {
                swal("Grupo", "Grupo Cadastrado com sucesso!", "success");
            }
            $scope.buscaUsuario();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.grupo.idGrupo = "";
        $scope.grupo.descricaoGrupo = "";
        $scope.grupo.tipoUsuario = "";
        $scope.editando = false;
    }

    $scope.deleteGrupo = function (id) {
        GrupoFactory.deleteGrupo($scope.callbackDeleteGrupo, id);
    }

    $scope.callbackDeleteGrupo = function (resposta) {
        if (resposta.status != 200) {
            swal("Grupo", "Erro ao deletar o Grupo!", "error");
        } else {
            swal("Grupo", "Grupo deletado com sucesso!", "success");
            $scope.limpaCampos();
        }
    }
});
