
myapp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    //$scope.dados = [{"idUsuario":1, "idGrupo":1, "login":"j0nasp3r", "Nome":"Jonas", "Ativo":'F'}];

    $scope.editando = false;

    $scope.buscaUsuarios = function () {
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }

    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarUsuario = function () {
        $scope.editando = !$scope.editando;
    }

    $scope.cadastroUsuario = function (usuario) {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }

    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Contas", "Conta Cadastrada com sucesso!", "error");
        } else {
            //alert("OK");
            swal("Usuario", "Usuario Cadastrado com sucesso!", "success");
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }

    $scope.limpaCampos = function () {
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.senha = "";
        $scope.usuario.idGrupo = "";
        $scope.usuario.flagInativo = "";
    }
});


