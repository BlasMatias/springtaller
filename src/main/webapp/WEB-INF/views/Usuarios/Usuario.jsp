<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroUsuario">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="/springtaller/resources/angular/angular.js"></script>
	<!--Import Google Icon Font-->
	<link href="/springtaller/resources/materialize/iconos/index.css" rel="stylesheet">
	
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="/springtaller/resources/materialize/css/materialize.min.css"  media="screen,projection"/>
	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>




<body ng-controller="usuarioController">
<h2 ng-bind="aplicativo"></h2>
<div class="row">
<div class="col s2"></div>
<form class="col s8">

<div class="card-panel">
<div class="row">

	<div class="input-field col s6">
	        
	           <input id="login" type="text" class="validate" ng-model="usuario.login" >
	           <label for="login">ejemplo </label>
	        </div>
	        
	        <div class="input-field col s6">
	           <input id="login" type="text" class="validate" ng-model="usuario.name" >
	           <label for="login">Cuando ejemplo</label>
	        </div>
	         <div class="input-field col s6">
<!-- 	          <i class="material-icons prefix">payment</i> -->
	          <input id="name" type="text"  class="validate" ng-model="usuario.password">
	          <label for="total">Precio</label>
	        </div>
	         </div>
	      <button ng-click="registrarUsuario(usuario)" class="btn waves-effect waves-light" type="submit" name="action">Guardar
	   		<i class="material-icons right">save</i>
	  	  </button>
	      </div>
</form>
</div>  


<div class="row">
  <div class="col s12">
   <table class="responsive-table" >
        <thead>
          <tr>
              <th>login</th>
              <th>name</th>
              <th>password</th>
              
          </tr>
        </thead>

        <tbody>
          <tr ng-repeat="usuario in usuarios">
            <td>{{usuario.login}}</td>
            <td>{{usuario.name}}</td>
            <td>{{usuario.password}}</td>
            
          </tr>
        </tbody>
      </table></div>
  </div>


</div>


<!--Import jQuery before materialize.js-->
  	<script type="text/javascript" src="/springtaller/resources/jquery.js"></script>
  
  	<script type="text/javascript">
  	$(document).ready(function() {
  	    $('select').material_select();
  	  	$('.datepicker').pickadate();
  	  });
</script>
	
	<script type="text/javascript" src="/springtaller/resources/materialize/js/materialize.min.js"></script>
	<script type="text/javascript">

			// declaramos el modulo principal
			angular.module("registroUsuario",[]);
			// accedemos al modulo
			angular.module("registroUsuario").controller("usuarioController",function($scope,$http){
// 				$scope= intermediario
				$scope.aplicativo="Registro de Usuario";
				$scope.registrarUsuario=function(usuario){
					$http.post("http://localhost:8080/springtaller/usuario",usuario).success(function(){
						delete $scope.usuario;
						cargarUsuarios();
					});
				};
				var cargarUsuarios = function(){
					$http.get("http://localhost:8080/springtaller/usuario").success(function(usuarios){
						$scope.usuarios=usuarios;
					});
				};
				cargarUsuarios();
			});

</script>

</body>
</html>









