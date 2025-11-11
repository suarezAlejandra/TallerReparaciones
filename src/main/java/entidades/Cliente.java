package entidades;

public class Cliente {
	// Atributos
	private int id_cliente;
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	
	// Constructor
	public Cliente(String dni, String nombre, String telefono, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	// Getters y Setters
	public int getId_cliente() {
		return id_cliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// ToString
	@Override
	public String toString() {
		return "ID: " + id_cliente + ", DNI: " + dni + ", nombre: " + nombre +
				", telefono: " + telefono + ", email: " + email;
	}
}
