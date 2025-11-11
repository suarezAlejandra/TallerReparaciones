package dao.mysql;

import dao.interfaces.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAO {

	@Override
	public boolean login(String dni, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario finByNombreUsuario(String nombre_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
