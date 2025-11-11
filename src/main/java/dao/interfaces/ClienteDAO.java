package dao.interfaces;

import java.util.ArrayList;
import entidades.Cliente;

public interface ClienteDAO {
	int insert(Cliente c);
	int update(Cliente c);
	int delete(Cliente c);
	Cliente findByDni(String dni);
	ArrayList<Cliente> findall();
}
