package py.edu.facitec.springtaller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//significa que creara una tabla cliente
@Entity
public class Cliente {
	
	//identicacion de clave primaria
	@Id
	//generacion automatica de valor
	@GeneratedValue
	private Integer id;
	
	private String nombre;
	private String correo;

	
	//anotacion que sirve para aclara que de uno para mucho
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", pedidos=" + pedidos + "]";
	}
	
	
	
	}
