<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroPedido">
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
<body ng-controller="pedidoController">
<h2 ng-bind="aplicativo"></h2>
<div class="row">
<div class="col s2"></div>
<form class="col s8">

<div class="card-panel">
<div class="row">

	<div class="input-field col s6">
	          <i class="material-icons prefix">date_range</i>
	           <input id="fechaToma" type="date" class="datepicker" ng-model="pedido.fechaToma" >
	           <label for="fechaToma">Fecha Toma </label>
	        </div>
	        
	        <div class="input-field col s6">
	          <i class="material-icons prefix">date_range</i>
	           <input id="fechaEntrega" type="date" class="datepicker" ng-model="pedido.fechaEntrega" >
	           <label for="fechaEntrega">Fecha Entrega</label>
	        </div>
	         <div class="input-field col s6">
<!-- 	          <i class="material-icons prefix">payment</i> -->
	          <input id="total" type="number" min="0" class="validate" ng-model="pedido.total">
	          <label for="total">Precio</label>
	        </div>
	         </div>
	      <button ng-click="registrarPedido(pedido)" class="btn waves-effect waves-light" type="submit" name="action">Guardar
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
              <th>fechaToma</th>
              <th>fechaEntrega</th>
              <th>total</th>
              
          </tr>
        </thead>

        <tbody>
          <tr ng-repeat="pedido in pedidos">
            <td>{{pedido.fechaToma}}</td>
            <td>{{pedido.fechaEntrega}}</td>
            <td>{{pedido.total}}</td>
            
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
			angular.module("registroPedido",[]);
			// accedemos al modulo
			angular.module("registroPedido").controller("pedidoController",function($scope,$http){
// 				$scope= intermediario
				$scope.aplicativo="Registro de Pedido";
				$scope.registrarPedido=function(pedido){
					$http.post("http://localhost:8080/springtaller/pedido",pedido).success(function(){
						delete $scope.pedido;
						cargarPedidos();
					});
				};
				var cargarPedidos = function(){
					$http.get("http://localhost:8080/springtaller/pedido").success(function(pedidos){
						$scope.pedidos=pedidos;
					});
				};
				cargarPedidos();
			});

</script>

</body>
</html>