package dao;

import dao.mysql.ClienteDAOMySQL;
import dao.mysql.ReparacionDAOMySQL;
import dao.mysql.UsuarioDAOMySQL;
import dao.mysql.VehiculoDAOMySQL;

public class MySQLDAOFactory implements DAOFactory {
	@Override
	public ClienteDAOMySQL getClienteDAO() {
		return new ClienteDAOMySQL;
	}

	@Override
	public ReparacionDAOMySQL getReparacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDAOMySQL getUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehiculoDAOMySQL getVehiculoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
