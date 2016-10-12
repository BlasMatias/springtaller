package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;

//nos senhala que va a gestionar nuestra entidad
@Repository 
//clase que se encarga de la manipulacion de los datos, posibilita posteriormente utilizar la anotacion 
//Auwired
public class ClienteDAO extends DAOGenerico<Cliente>{ 

	@PersistenceContext  	
	private EntityManager em;
	
	 
	public ClienteDAO() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
} 

