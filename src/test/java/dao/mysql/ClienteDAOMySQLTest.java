package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.interfaces.ClienteDAO;
import entidades.Cliente;



class ClienteDAOMySQLTest {

	@Test
	void testInsert() {
		// Crear cliente
		Cliente c = new Cliente("12345678A", "Alejandra", "666777888", "alejandra@gmail.com");
		
		int resul = 0;
		
		// Crear clienteDAO
		ClienteDAO cDAO = new ClienteDAOMySQL();
		
		// Llamar al insert de ClienteDAO con el Cliente
		cDAO.insert(c);
		
		// Comprobar
		assertEquals(1, resul);
	}

}
