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

import py.edu.facitec.springtaller.dao.UsuarioDAO;
import py.edu.facitec.springtaller.model.Usuario;

public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
		usuarioDAO.guardar(usuario, usuario.getLogin());
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarTodos(){
		List<Usuario> usuarios = usuarioDAO.buscarTodos();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login){
		Usuario usuario = usuarioDAO.buscar(login);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> eliminar(@PathVariable String login){
		Usuario usuario = usuarioDAO.buscar(login);
		if (usuario==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuarioDAO.eliminar(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
