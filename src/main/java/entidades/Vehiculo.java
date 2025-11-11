package entidades;

public class Vehiculo {
	// Atributos
	private int id_vehiculo;
	private String matricula;
	private String marca;
	private String modelo;
	
	// Constructor
	public Vehiculo(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	// Getters y Setters
	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	// toString
	@Override
	public String toString() {
		return "ID: " + id_vehiculo + ", matrícula: " + matricula + ", marca: " + marca + ", modelo: " + modelo;
	}
}
