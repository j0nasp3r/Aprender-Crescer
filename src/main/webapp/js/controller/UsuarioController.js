
myapp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory){
   
    //$scope.dados = [{"idUsuario":1, "idGrupo":1, "login":"j0nasp3r", "Nome":"Jonas", "Ativo":'F'}];
    
    $scope.editando = false;
    
    $scope.buscaUsuarios = function(){
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }
    
    $scope.callbackUsuarios = function(resposta){
        $scope.dados = resposta.data;
    } 
    
    $scope.editarUsuario = function(){
        $scope.editando = !$scope.editando;
    }
    
    $scope.cadastroUsuario = function(usuario){
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }
    
    $scope.callbackCadastroUsuario = function(resposta){
        if(resposta.status != 200){
            alert("Deu erro");
        }else{
            alert("OK");
        }
    }
    
});


