package dao.mysql;

import dao.interfaces.ClienteDAO;

public class ClienteDAOMySQL implements ClienteDAO {
	int insert(Cliente c);
	int update(Cliente c);
	int delete(Cliente c);
	ArrayList<Cliente> findall();
	Cliente findByDni(String dni);
}
