package py.edu.facitec.springtaller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.edu.facitec.springtaller.dao.PedidoDAO;
import py.edu.facitec.springtaller.model.Pedido;

public class PedidoController {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		pedidoDAO.guardar(pedido, pedido.getId());
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> buscarTodos(){
		List<Pedido> pedidos = pedidoDAO.buscarTodos();
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
		Pedido pedidoBuscado = pedidoDAO.buscar(id);
		return new ResponseEntity<Pedido>(pedidoBuscado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
		Pedido pedidoAEliminar = pedidoDAO.buscar(id);
		if (pedidoAEliminar == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pedidoDAO.eliminar(pedidoAEliminar);
		return new ResponseEntity<>(HttpStatus.OK);
	
	
}
	}
