package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Usuario;
	//paso de la clase usuario se convierte en objeto

@Repository //anotacion que manipulara los datos
public class UsuarioDAO extends DAOGenerico<Usuario>{
	
	//contexto de persistencia o manupulador de entidades
	@PersistenceContext
	private EntityManager em;

	@Override// sobreescritura no borrar mas
	protected EntityManager getEntityManager() {
		
		return em;
	}
	//le pasamos todos los atributos al metodo
	public UsuarioDAO() {
		//paso de la clase Usuario al dao generico
		super(Usuario.class);
	}
	

}
