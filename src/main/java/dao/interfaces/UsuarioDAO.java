package dao.interfaces;

import entidades.Usuario;

public interface UsuarioDAO {
	boolean login(String dni, String password);
	int insert(Usuario u);
	int update(Usuario u);
	int delete(Usuario u);
	Usuario findByNombreUsuario(String nombre_usuario);
}
