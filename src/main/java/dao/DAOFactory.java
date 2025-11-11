package dao;

import dao.mysql.ClienteDAOMySQL;
import dao.mysql.ReparacionDAOMySQL;
import dao.mysql.UsuarioDAOMySQL;
import dao.mysql.VehiculoDAOMySQL;

public interface DAOFactory {
	public ClienteDAOMySQL getClienteDAO();
	
	public ReparacionDAOMySQL getReparacionDAO();
	
	public UsuarioDAOMySQL getUsuarioDAO();
	
	public VehiculoDAOMySQL getVehiculoDAO();
}
