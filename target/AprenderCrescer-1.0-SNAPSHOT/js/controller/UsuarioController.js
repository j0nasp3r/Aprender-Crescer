
myapp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory){
   
    $scope.dados = [{"idUsuario":1, "idGrupo":1, "login":"j0nasp3r", "Nome":"Jonas", "Ativo":'F'}];
    
    $scope.buscaUsuarios = function(){
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }
    
    $scope.callbackUsuarios = function(resposta){
        $scope.dados = resposta.data;
    } 
});


