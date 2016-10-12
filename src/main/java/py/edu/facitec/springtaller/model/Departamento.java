package py.edu.facitec.springtaller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Departamento {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String descripcion;
	
	//indicamos que la relacion es de uno a uno
	@OneToOne
	private Gerente gerente;
	
	@OneToMany(mappedBy="departamento")
	private List<Usuario> listaUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", descripcion=" + descripcion + ", gerente=" + gerente + ", listaUsuario="
				+ listaUsuario + "]";
	}
	
	
	
	
	

}
