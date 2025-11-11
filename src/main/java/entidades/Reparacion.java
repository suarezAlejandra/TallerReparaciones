package entidades;

import java.time.LocalDate;

public class Reparacion {
	// Atributos
	private int id_reparacion;
	private static int id = 0;
	private String descripcion;
	private LocalDate fecha_entrada;
	private double coste_estimado;
	private String estado;
	
	// Constructor
	public Reparacion(String descripcion, LocalDate fecha_entrada, double coste_estimado, String estado) {
		// ID
		this.id_reparacion = id++;
		// Resto de atributos
		this.descripcion = descripcion;
		this.fecha_entrada = fecha_entrada;
		this.coste_estimado = coste_estimado;
		this.estado = estado;
	}
	
	// Getters y Setters
	public int getId_reparacion() {
		return id_reparacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public double getCoste_estimado() {
		return coste_estimado;
	}

	public void setCoste_estimado(double coste_estimado) {
		this.coste_estimado = coste_estimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	// toString
	@Override
	public String toString() {
		return "ID: " + id_reparacion + ", descripción: " + descripcion + ", fecha entrada: " +
				fecha_entrada + ", coste estimado: " + coste_estimado + ", estado: " + estado;
	}
}
