
myapp.controller('ContaController', function ContaController($scope, $http, ContaFactory){
   
    //$scope.dados = [{"idConta":1, "descricao":"fatura de agua", "tipoConta":"debito", "valor":100}];
    
    $scope.buscaContas = function(){
        ContaFactory.getContas($scope.callbackContas);
    }
    
    $scope.callbackContas = function(resposta){
        $scope.dados = resposta.data;
    } 

    $scope.editarContas = function () {
        $scope.editando = !$scope.editando;
    }

    $scope.cadastroContas = function (conta) {
        ContaFactory.setContas($scope.callbackCadastroContas, conta);
    }

    $scope.callbackCadastroContas = function (resposta) {
        if (resposta.status != 200) {
            swal("Contas", "Conta Cadastrada com sucesso!", "error");
        } else {
            //alert("OK");
            swal("Contas", "Conta Cadastrada com sucesso!", "success");
            $scope.buscaContas();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.conta.descricao = "";
        $scope.conta.tipoConta = "";
        $scope.conta.valor = "";
    }
});