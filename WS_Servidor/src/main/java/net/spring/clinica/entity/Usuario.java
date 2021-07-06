package net.spring.clinica.entity;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private int codUsuario;
	
	private String login;
	
	private String password;

	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;
	
	/*
	
	@ManyToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	
	*/
	public Usuario() {
		
	}
	
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	/*
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	*/
	
}