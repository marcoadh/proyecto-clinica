package net.spring.clinica.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tipo_empleado")
public class TipoEmpleado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoEmpleado")
	private int codigoTipoEmpleado;
	
	@Column(name = "nombre")
	private String nombreTipoEmpleado;
	
	@JsonIgnore
	//relación uno "TipoEmpleado" a muchos "Empleado"
	@OneToMany(mappedBy = "tipoEmpleado")//ASOCIACIÓN
	private List<Empleado> listaTipoEmpleado;

	public int getCodigoTipoEmpleado() {
		return codigoTipoEmpleado;
	}

	public void setCodigoTipoEmpleado(int codigoTipoEmpleado) {
		this.codigoTipoEmpleado = codigoTipoEmpleado;
	}

	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}

	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}

	public List<Empleado> getListaTipoEmpleado() {
		return listaTipoEmpleado;
	}

	public void setListaTipoEmpleado(List<Empleado> listaTipoEmpleado) {
		this.listaTipoEmpleado = listaTipoEmpleado;
	}
	
	
	
}




