
myapp.controller('ContaController', function ContaController($scope, $http, ContaFactory) {

    //$scope.dados = [{"idConta":1, "descricao":"fatura de agua", "tipoConta":"debito", "valor":100}];

    $scope.buscaConta = function () {
        ContaFactory.getConta($scope.callbackConta);
    }

    $scope.callbackConta = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarConta = function (item) {
        $scope.editando = true;
        $scope.conta = angular.copy(item);
    }

    $scope.cadastroConta = function (conta) {
        if (conta.idGrupo && conta.idGrupo != 0) {
            ContaFactory.updateConta($scope.callbackCadastroConta, conta);
        } else {
            ContaFactory.setConta($scope.callbackCadastroConta, conta);
        }
    }

    $scope.callbackCadastroConta = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Conta", "Erro ao atualizar o cadastro de Conta!", "error");
            } else {
                swal("Conta", "Erro ao cadastrar o Conta!", "error");
            }
        } else {
            if ($scope.editando == true) {
                swal("Conta", "Conta salvo com sucesso!", "success");
            } else {
                swal("Conta", "Conta Cadastrado com sucesso!", "success");
            }
            $scope.buscaConta();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        var conta = {idConta: "", descricao: "", tipoConta: "", valor: ""}
        $scope.conta = conta;
        $scope.editando = false;
    }

    $scope.deleteConta = function (id) {
        ContaFactory.deleteConta($scope.callbackDeleteConta, id);
    }

    $scope.callbackDeleteConta = function (resposta) {
        if (resposta.status != 200) {
            swal("Conta", "Erro ao deletar a Conta!", "error");
        } else {
            swal("Conta", "Conta deletada com sucesso!", "success");
            $scope.limpaCampos();
            $scope.buscaConta();
        }
    }

});