package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import dao.DAOFactory;
import dao.MySQLDAOFactory;
import entidades.Usuario;
import entidades.Reparacion;
import entidades.Vehiculo;
import entidades.Cliente;
import dao.interfaces.UsuarioDAO;
import dao.interfaces.ClienteDAO;
import dao.interfaces.VehiculoDAO;
import dao.interfaces.ReparacionDAO;

public class ControladorTaller {
	// SINGLETON
	private static ControladorTaller instance;
	private DAOFactory daoFactory;
	private Usuario usuarioActual;
	
	private ControladorTaller() {
		this.daoFactory = new MySQLDAOFactory();
	}
	
	public static ControladorTaller getInstance() {
		if (instance == null) {
			instance = new ControladorTaller();
		}
		return instance;
	}
	
	
	// ----CU1: VER REPARACIONES FINALIZADAS----
	public ArrayList<Reparacion> verReparacionesFinalizadas() {
		// Crear reparacionDAO
		ReparacionDAO reparacion = daoFactory.getReparacionDAO();
		
		// Guardar en la lista las reparaciones con estado "finalizada"
		// Para ello filtramos con findByEstado donde el estado sea "finalizada"
		ArrayList<Reparacion> reparaciones = reparacion.findByEstado("finalizada");
		
		// Ordenar array por fecha
        reparaciones.sort((r1, r2) -> r1.getFecha_entrada().compareTo(r2.getFecha_entrada()));
        
        // Devolvemos array de reparaciones finalizadas
        return reparaciones;
	}
	
	
	// ----CU2: INICIO DE SESIÓN----
	
	/* Método que devuelve true si la sesión está activa (el usuario se ha identificado,
	es decir, no es nulo) o false si no se ha iniciado sesión */
	public boolean sesionActiva() {
		// La sesión está activa si el usuarioActual no es nulo
		if (usuarioActual != null) {
			return true;
		} else {
			return false;
		}
	}
	
	// Getter usuarioActual
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	// Getter del rol del usuarioActual
	public String getRolActual() {
		// Si el usuarioActual es nulo (no se ha identificado) es invitado
		if (usuarioActual == null) {
			return "Invitado";
		} else {
			return usuarioActual.getRol();
		}
	}
	
	// Obtener rol específico: mecánico
	public boolean esMecanico() {
		if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("mecanico")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Obtener rol específico: admin
	public boolean esAdmin() {
		if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("administrador")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Inicio de sesión
	public boolean login(String nombreUsuario, String password) {
		// Crear usuarioDAO
		UsuarioDAO usuario = daoFactory.getUsuarioDAO();
		
		// Comprobar credenciales, para ello primer lo logeamos
		boolean usuarioValido = usuario.login(nombreUsuario, password);
		
		if (!usuarioValido) {
			// No es valido
			return false;
		}
		
		// Si es válido, recuperar usuario para la sesión
		Usuario u = usuario.findByNombreUsuario(nombreUsuario);
		if (u != null) {
			this.usuarioActual = u;
			return true;
		}
		
		// Si no se recupera:
		return false;
	}
	
	// Salir de la sesión
	public void logout() {
		this.usuarioActual = null;
	}

	
	
	// ----CU3: REGISTRAR OPERACIÓN (mecanico)----
	public void registrarOperacion(String matricula, String descripcion, LocalDate fecha_entrada, double coste_estimado, String estado) {
		// Crear vehiculoDAO
		VehiculoDAO vDAO = daoFactory.getVehiculoDAO();
		
		// Creamos vehículo buscando la matricula dada
		Vehiculo vehiculo = vDAO.findByMatricula(matricula);
		
		// El vehiculo no existe
		if (vehiculo == null) {
			System.out.println("> El vehículo con matrícula " + matricula + " no existe.");;
		} else {
			// Crear reparacionDAO
			ReparacionDAO rDAO = daoFactory.getReparacionDAO();
			
			// Crear nueva reparacion
			Reparacion reparacion = new Reparacion(descripcion, fecha_entrada, coste_estimado, "pendiente");
			
			// Insertarla 
			rDAO.insert(reparacion);
		}
	}
	
	
	// ----CU4: CAMBIAR ESTADO DE REPARACIÓN (mecanico)----
	public void cambiarEstadoReparacion(int id, String estado) {
		// Crear reparacionDAO
		ReparacionDAO rDAO = daoFactory.getReparacionDAO();
		
		// Crear reparacion buscando el ID dado
		Reparacion reparacion = rDAO.findById(id);
		
		// La reparacion con ID no existe
		if (reparacion == null) {
			System.out.println("> La reparación con ID " + id + " no existe.");;
		} else {
			reparacion.setEstado(estado);
			rDAO.update(reparacion);
		}
	}
	
	
	// ----CU5: GESTIÓN DE CLIENTES Y VEHÍCULOS (admin)----
	// GESTIÓN DE CLIENTES
	public ArrayList<Cliente> verClientes() {
		// Crear clienteDAO
		ClienteDAO cDAO = daoFactory.getClienteDAO();
		
		// Devolver listado
		return cDAO.findall();
	}
	
	public void crearCliente(String dni, String nombre, String telefono, String email) {
		// Crear ClienteDAO
		ClienteDAO cDAO = daoFactory.getClienteDAO();
		
		// Crear cliente nuevo
		Cliente cliente = new Cliente(dni, nombre, telefono, email);
		
		// Insertarlo
		cDAO.insert(cliente);
	}
	
	public void actualizarCliente(String dni, String nombre, String telefono, String email) {
		// Crear ClienteDAO
		ClienteDAO cDAO = daoFactory.getClienteDAO();
				
		// Crear cliente a partir del dni
		Cliente cliente = cDAO.findByDni(dni);
		
		// Cliente no existe
		if (cliente == null) {
			System.out.println("> El cliente con DNI " + dni + " no existe.");
		} else {
			// Si existe, actualizamos datos
			cliente.setNombre(nombre);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			
			// Actualizamos
			cDAO.update(cliente);
		}
	}
	
	public void eliminarCliente(String dni) {
		// Crear ClienteDAO
		ClienteDAO cDAO = daoFactory.getClienteDAO();
						
		// Crear cliente a partir del dni
		Cliente cliente = cDAO.findByDni(dni);
		
		// Eliminamos cliente
		cDAO.delete(cliente);
	}
	
	// GESTIÓN DE VEHÍCULOS
	public ArrayList<Vehiculo> verVehiculos() {
		// Crear vehiculoDAO
		VehiculoDAO vDAO = daoFactory.getVehiculoDAO();
		
		// Devolver listado
		return vDAO.findall();
	}
	
	public void crearVehiculo(String matricula, String marca, String modelo) {
		// Crear VehiculoDAO
		VehiculoDAO vDAO = daoFactory.getVehiculoDAO();
		
		// Crear vehiculo nuevo
		Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo);
		
		// Insertarlo
		vDAO.insert(vehiculo);
	}
	
	public void actualizarVehiculo(String matricula, String marca, String modelo) {
		// Crear VehiculoDAO
		VehiculoDAO vDAO = daoFactory.getVehiculoDAO();
				
		// Crear vehiculo a partir de la matricula
		Vehiculo vehiculo = vDAO.findByMatricula(matricula);
		
		// Vehiculo no existe
		if (vehiculo == null) {
			System.out.println("> El vehículo con matrícula " + matricula + " no existe.");
		} else {
			// Si existe, actualizamos datos
			vehiculo.setMarca(marca);
			vehiculo.setModelo(modelo);
			
			// Actualizamos
			vDAO.update(vehiculo);
		}
	}
	
	public void eliminarVehiculo(String matricula) {
		// Crear VehiculoDAO
		VehiculoDAO vDAO = daoFactory.getVehiculoDAO();
						
		// Crear vehiculo a partir de la matricula
		Vehiculo vehiculo = vDAO.findByMatricula(matricula);
		
		// Eliminamos vehiculo
		vDAO.delete(vehiculo);
	}
	
	
	// ----CU6: ESTADÍSTICAS (admin)----
}
