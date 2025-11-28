package vista;

import java.util.Scanner;
import java.util.ArrayList;
import controlador.ControladorTaller;
import entidades.Cliente;
import entidades.Reparacion;
import entidades.Vehiculo;

public class VistaTaller {
	
	private Scanner sc;
	private ControladorTaller controlador;
	
	public VistaTaller() {
		this.sc = new Scanner(System.in);
		this.controlador = ControladorTaller.getInstance();
	}
	
	public static void main(String[] args) {
		VistaTaller vista = new VistaTaller();
		vista.iniciar();
	}
	
	// MÉTODO INICIAR
	public void iniciar() {
		boolean salir = false;
		
		/* Mientras que no se desee salir, se realizará el siguiente while
		que muestra el menú interactivo */
		do {
			// Cabecera
			System.out.println("\n-------------------------------");
			System.out.println("-------TALLER REPARACIONES-------");
			System.out.println("-------------------------------");
			System.out.println("PERFIL: " + controlador.getRolActual());
			System.out.println();
			
			// A continuación, depende del rol del usuario, aparecerá un menú u otro
			String tipoUsuario = null;
			if (!controlador.sesionActiva()) {
				// Invitado
				tipoUsuario = "invitado";
			} else if (controlador.esMecanico()) {
				// Mecanico
				tipoUsuario = "mecanico";
			} else if (controlador.esAdmin()) {
				// Admin
				tipoUsuario = "admin";
			}
			
			switch(tipoUsuario) {
				case "invitado":
					salir = menuInvitado();
					break;
				case "mecanico":
					menuMecanico();
					break;
				case "admin":
					menuAdmin();
					break;
			}
		} while (!salir);
		
		// Mensaje al salir
		System.out.println("Saliendo del programa...");
		sc.close();
	}
	
	// MENÚ INVITADO
	public boolean menuInvitado() {
		System.out.println("1. Login");
		System.out.println("2. Ver reparaciones finalizadas");
		System.out.println("0. Salir");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:
				login();
				break;
			case 2:
				verReparacionesFinalizadas();
				break;
			case 0:
				return true;
			default:
				System.out.println("> Opción inválida");
		}
		return false;
	}
	
	public void login() {
		sc.nextLine();
		System.out.print("> Nombre de usuario: ");
		String usuario = sc.nextLine();
		System.out.print("> Contraseña: ");
		String pass = sc.nextLine();
		
		boolean credencialesCorrectas = controlador.login(usuario, pass);
		if (credencialesCorrectas) {
			System.out.println("> LOGIN CORRECTO. Bienvenidx " + controlador.getUsuarioActual());
		} else {
			System.out.println("> CREDENCIALES INCORRECTAS");
		}
		System.out.println();
	}
	
	public void verReparacionesFinalizadas() {
		ArrayList<Reparacion> reparaciones = controlador.verReparacionesFinalizadas();
		
		// La lista está vacía
		if (reparaciones.isEmpty()) {
			System.out.println("> No hay reparaciones finalizadas");
		} else {
			System.out.println("> REPARACIONES FINALIZADAS:");
			for (Reparacion r : reparaciones) {
				System.out.println("\t" + r);
			}
			System.out.println();
		}
	}
	
	
	// MENÚ MECÁNICO
	public void menuMecanico() {
		System.out.println("1. Ver reparaciones finalizadas");
		System.out.println("2. Registrar reparación");
		System.out.println("3. Cambiar estado de reparación");
		System.out.println("0. Cerrar sesión");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:
				verReparacionesFinalizadas();
				break;
			case 2:
				registrarReparacion();
				break;
			case 3:
				cambiarEstado();
				break;
			case 0:
				logout();
				break;
			default:
				System.out.println("> Opción inválida");
		}
	}
	
	public void registrarReparacion() {
		System.out.print("> Matrícula del vehículo: ");
		String matricula = sc.nextLine();
		System.out.print("> Descripción: ");
		String descripcion = sc.nextLine();
		System.out.print("> Fecha de entrada (AAAA-MM-DD): ");
		String fecha = sc.nextLine();
		System.out.print("> Coste estimado: ");
		String coste = sc.nextLine();
		System.out.print("> Estado: ");
		String estado = sc.nextLine();

		controlador.registrarOperacion(
					matricula, 
					descripcion, 
					java.time.LocalDate.parse(fecha), 
					Double.parseDouble(coste), 
					estado);
		System.out.println();
	}
	
	public void cambiarEstado() {
		System.out.print("> ID de la reparación: ");
		int id = sc.nextInt();
		System.out.print("> Nuevo estado (pendiente / en curso / finalizada): ");
		String estado = sc.nextLine();
		
		controlador.cambiarEstadoReparacion(id, estado);
		System.out.println();
	}
	
	public void logout() {
		controlador.logout();
		System.out.println("Cerrando sesión...");
		System.out.println();
	}
	
	
	// MENÚ ADMIN
	public void menuAdmin() {
		System.out.println("1. Ver reparaciones finalizadas");
		System.out.println("2. Gestión de clientes");
		System.out.println("3. Gestión de vehículos");
		System.out.println("4. Ver estadísticas");
		System.out.println("0. Cerrar sesión");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:
				verReparacionesFinalizadas();
				break;
			case 2:
				gestionClientes();
				break;
			case 3:
				gestionVehiculos();
				break;
			case 4:
				verEstadisticas();
				break;
			case 0:
				logout();
				break;
			default:
				System.out.println("> Opción inválida");
		}
	}
	
	public void verEstadisticas() {
		//???
	}
	
	public void gestionClientes() {
		System.out.println("1. Ver clientes");
		System.out.println("2. Crear cliente");
		System.out.println("3. Actualizar cliente");
		System.out.println("4. Eliminar cliente");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:
				verClientes();
				break;
			case 2:
				crearCliente();
				break;
			case 3:
				actualizarCliente();
				break;
			case 4:
				eliminarCliente();
				break;
			default:
				System.out.println("> Opción inválida");
		}
	}
	
	public void verClientes() {
		ArrayList<Cliente> clientes = controlador.verClientes();
		
		if (clientes.isEmpty()) {
			System.out.println("> No hay clientes");
		} else {
			System.out.println("> CLIENTES:");
			for (Cliente c : clientes) {
				System.out.println("\t" + c);
			}
		}
		System.out.println();
	}
	
	public void crearCliente() {
		System.out.print("> DNI: ");
		String dni = sc.nextLine();
		System.out.print("> Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("> Teléfono: ");
		String telefono = sc.nextLine();
		System.out.print("> Email: ");
		String email = sc.nextLine();
		
		controlador.crearCliente(dni, nombre, telefono, email);
		System.out.println();
	}
	
	public void actualizarCliente() {
		System.out.print("> DNI del cliente a actualizar: ");
		String dni = sc.nextLine();
		System.out.print("> Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("> Teléfono: ");
		String telefono = sc.nextLine();
		System.out.print("> Email: ");
		String email = sc.nextLine();
		
		controlador.actualizarCliente(dni, nombre, telefono, email);
		System.out.println();
	}
	
	public void eliminarCliente() {
		System.out.print("> DNI del cliente a eliminar: ");
		String dni = sc.nextLine();
		
		controlador.eliminarCliente(dni);
		System.out.println();
	}
	
	public void gestionVehiculos() {
		System.out.println("1. Ver vehículos");
		System.out.println("2. Crear vehículo");
		System.out.println("3. Actualizar vehículo");
		System.out.println("4. Eliminar vehículo");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		switch(opcion) {
			case 1:
				verVehiculos();
				break;
			case 2:
				crearVehiculo();
				break;
			case 3:
				actualizarVehiculo();
				break;
			case 4:
				eliminarVehiculo();
				break;
			default:
				System.out.println("> Opción inválida");
		}
	}
	
	public void verVehiculos() {
		ArrayList<Vehiculo> vehiculos = controlador.verVehiculos();
		
		if (vehiculos.isEmpty()) {
			System.out.println("> No hay vehículos");
		} else {
			System.out.println("> VEHÍCULOS:");
			for (Vehiculo v : vehiculos) {
				System.out.println("\t" + v);
			}
		}
		System.out.println();
	}
	
	public void crearVehiculo() {
		System.out.print("> Matrícula: ");
		String matricula = sc.nextLine();
		System.out.print("> Marca: ");
		String marca = sc.nextLine();
		System.out.print("> Modelo: ");
		String modelo = sc.nextLine();
		
		controlador.crearVehiculo(matricula, marca, modelo);
		System.out.println();
	}
	
	public void actualizarVehiculo() {
		System.out.print("> Matrícula del vehículo a actualizar: ");
		String matricula = sc.nextLine();
		System.out.print("> Marca: ");
		String marca = sc.nextLine();
		System.out.print("> Modelo: ");
		String modelo = sc.nextLine();
		
		controlador.actualizarVehiculo(matricula, marca, modelo);
		System.out.println();
	}
	
	public void eliminarVehiculo() {
		System.out.print("> Matrícula del vehículo a eliminar: ");
		String matricula = sc.nextLine();
		
		controlador.eliminarVehiculo(matricula);
		System.out.println();
	}
}
