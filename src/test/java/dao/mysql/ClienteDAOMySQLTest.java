package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import entidades.Cliente;
import dao.interfaces.ClienteDAO;

class ClienteDAOMySQLTest {
	
	@Test
	void testInsert() {	
		Cliente c1 = new Cliente("58429549G", "Alejandra", "610778385", "alejandrasf@gmail.com");
		int resul = 0;
				
		// Crear clienteDAO
		ClienteDAO cDAO = new ClienteDAOMySQL();
				
		// Llamar al insert de ClienteDAO con el Cliente
		cDAO.insert(c1);
				
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testUpdate() {
		Cliente c2 = new Cliente("12123434D", "David", "620501626", "davideg@gmail.com");
		int resul = 0;
				
		// Crear clienteDAO
		ClienteDAO cDAO = new ClienteDAOMySQL();
				
		// Llamar al insert de ClienteDAO con el Cliente
		cDAO.insert(c2);
		
		// Ahora modifico el cliente 
		c2.setEmail("david2@gmail.com");
		
		// Actualizar cliente
		cDAO.update(c2);
		
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testDelete() {		
		Cliente c3 = new Cliente("10030497A", "Alejandro", "625326509", "asgranda@gmail.com");
		int resul = 0;
								
		// Crear clienteDAO
		ClienteDAO cDAO = new ClienteDAOMySQL();
		
		// Insertar cliente
		cDAO.insert(c3);
		
		// Llamar al delete de ClienteDAO con el Cliente
		cDAO.delete(c3);
								
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testFindByDni() {
		Cliente c1 = new Cliente("58429549G", "Alejandra", "610778385", "alejandrasf@gmail.com");
		Cliente c2 = new Cliente("12123434D", "David", "620501626", "davideg@gmail.com");
		Cliente c3 = new Cliente("10030497A", "Alejandro", "625326509", "asgranda@gmail.com");
		Cliente c4 = new Cliente("10023451M", "María José", "636684983", "mjose@gmail.com");
		Cliente c5 = new Cliente("12345678Z", "Zoe", "666666666", "zoe@gmail.com");
		
		Cliente c = null;
		
		// Crear ClienteDAO
		ClienteDAO cDAO = new ClienteDAOMySQL();
		
		// Insertar clientes
		cDAO.insert(c1);
		cDAO.insert(c2);
		cDAO.insert(c3);
		cDAO.insert(c4);
		cDAO.insert(c5);
		
		cDAO.findByDni("58429549G");
		
		// Comprobar
		assertEquals(c1, c);
	}

	@Test
	void testFindall() {
		Cliente c1 = new Cliente("58429549G", "Alejandra", "610778385", "alejandrasf@gmail.com");
		Cliente c2 = new Cliente("12123434D", "David", "620501626", "davideg@gmail.com");
		Cliente c3 = new Cliente("10030497A", "Alejandro", "625326509", "asgranda@gmail.com");
		Cliente c4 = new Cliente("10023451M", "María José", "636684983", "mjose@gmail.com");
		Cliente c5 = new Cliente("12345678Z", "Zoe", "666666666", "zoe@gmail.com");
	}

}
