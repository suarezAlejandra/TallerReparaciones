package controlador;

import dao.DAOFactory;
import dao.MySQLDAOFactory;
import entidades.Usuario;
import dao.interfaces.UsuarioDAO;

public class ControladorTaller {
	// PATRÓN SINGLETON
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
	
	// LOGIN
	public boolean sesionActiva() {
		if (usuarioActual != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public String getRolActual() {
		if (usuarioActual == null) {
			return "Invitado";
		} else {
			return usuarioActual.getRol();
		}
	}
	
	public boolean esMecanico() {
		if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("mecanico")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean esAdministrador() {
		if (usuarioActual != null && usuarioActual.getRol().equalsIgnoreCase("administrador")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean login(String dni, String password) {
		UsuarioDAO usuario = daoFactory.getUsuarioDAO();
		
		// Comprobamos credenciales
		boolean credencialesCorrectas = usuarioDAO.login(dni, password);
		
		// Credenciales invalidas
		if(!credencialesCorrectas) {
			return false;
		}
		
		// Credenciales válidas
		Usuario u = usuario.findByNombreUsuario(password)
	}
}
