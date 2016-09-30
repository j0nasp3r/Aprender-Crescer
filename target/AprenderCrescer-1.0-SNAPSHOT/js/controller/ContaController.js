
myapp.controller('ContaController', function ContaController($scope, $http, ContaFactory){
   
    $scope.dados = [{"idConta":1, "descricao":"fatura de agua", "tipoConta":"debito", "valor":100}];
    
    $scope.buscaContas = function(){
        ContaFactory.getContas($scope.callbackContas);
    }
    
    $scope.callbackContas = function(resposta){
        $scope.dados = resposta.data;
    } 
});