package py.edu.facitec.springtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.springtaller.dao.ProductoDAO;
import py.edu.facitec.springtaller.model.Producto;


@Transactional 
@RequestMapping("/producto") 
@RestController
public class ProductoController {
	
	@Autowired 
 	private ProductoDAO productoDAO; 
 
	
	//metodo Guardar
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	
												//anotacion que carga datos del objeto producto
	public  ResponseEntity<Producto> registrar(@RequestBody Producto producto){ 
 	 		productoDAO.guardar(producto, producto.getId()); 
 	 	return new ResponseEntity<Producto>(producto,HttpStatus.OK); 
 	} 
	
	
	//obtiene lista de producto
	//este metodo solo preduce json xq no tiene parametros
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarTodos(){
		
		//obtenemos la lista de producto
		List<Producto> productos= productoDAO.buscarTodos();
		
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	//buscar un producto por id
	@RequestMapping(method=RequestMethod.GET, value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
		
		Producto productoBuscado= productoDAO.buscar(id);
		
		return new ResponseEntity<Producto>(productoBuscado, HttpStatus.OK);
	}
	
	
	//metodo para eliminar
	@RequestMapping(method=RequestMethod.DELETE, value="{id}", consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
		
		Producto productoEliminar= productoDAO.buscar(id);
		
		
		if(productoEliminar==null){
			return new ResponseEntity<>(productoEliminar, HttpStatus.NOT_FOUND);
		}
		
		productoDAO.eliminar(productoEliminar);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
} 



