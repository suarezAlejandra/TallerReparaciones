package entidades;

public class Usuario {
	// Atributos
	private int id_usuario;
	private String dni;
	private String nombre_usuario;
	private String password;
	private String rol;
	
	// Constructor
	public Usuario(String dni, String nombre_usuario, String password, String rol) {
		this.dni = dni;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.rol = rol;
	}
	
	// Getters y Setters
	public int getId_usuario() {
		return id_usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	// toString
	@Override
	public String toString() {
		return "USUARIO ID: " + id_usuario + ", DNI: " + dni + ", Nombre de usuario: " + nombre_usuario +
				", Rol: " + rol;
	}
}
