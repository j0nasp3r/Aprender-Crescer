
myapp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    //$scope.dados = [{"idUsuario":1, "idGrupo":1, "login":"j0nasp3r", "Nome":"Jonas", "Ativo":'F'}];

    $scope.editando = false;

    $scope.buscaUsuario = function () {
        UsuarioFactory.getUsuarios($scope.callbackUsuario);
    }

    $scope.callbackUsuario = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarUsuario = function (item) {
        $scope.editando = true;
        /* $scope.usuario.nome = angular.copy(item.nome);
         $scope.usuario.login = angular.copy(item.login);
         $scope.usuario.senha = angular.copy(item.senha);
         $scope.usuario.idGrupo = angular.copy(item.idGrupo);
         $scope.usuario.flagInativo = angular.copy(item.flagInativo);*/

        $scope.usuario = angular.copy(item); //outra forma de passar os parametros; quando deseja utilizar tudo
    }

    $scope.cadastroUsuario = function (usuario) {
        if (usuario.idUsuario && usuario.idUsuario != 0) {
            UsuarioFactory.updateUsuario($scope.callbackCadastroUsuario, usuario);
        } else {
            UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
        }
    }

    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Usuario", "Erro ao atualizar o cadastro de usuário!", "error");
            } else {
                swal("Usuario", "Erro ao cadastrar o usuário!", "error");
            }
        } else {
            if ($scope.editando == true) {
                swal("Usuario", "Usuario salvo com sucesso!", "success");
            } else {
                swal("Usuario", "Usuario Cadastrado com sucesso!", "success");
            }
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.usuario.idUsuario = "";
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.senha = "";
        $scope.usuario.idGrupo = "";
        $scope.usuario.flagInativo = "";
        $scope.editando = false;
    }
    
    $scope.deleteUsuario = function (id){
        UsuarioFactory.deleteUsuario($scope.callbackDeleteUsuario,id);
    }
    
    $scope.callbackDeleteUsuario = function(resposta){
        if(resposta.status != 200){
            swal("Usuario", "Erro ao deletar o usuário!", "error");
        }else{
            swal("Usuario", "Usuario deletado com sucesso!", "success");
            $scope.limpaCampos();
        }
    }
});


