package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import entidades.Cliente;
import dao.interfaces.ClienteDAO;

class ClienteDAOMySQLTest {
	
	// Crear Clientes
	Cliente c1 = new Cliente("58429549G", "Alejandra", "610778385", "alejandrasf@gmail.com");
	Cliente c2 = new Cliente("12123434D", "David", "620501626", "davideg@gmail.com");
	Cliente c3 = new Cliente("10030497A", "Alejandro", "625326509", "asgranda@gmail.com");
	Cliente c4 = new Cliente("10023451M", "María José", "636684983", "mjose@gmail.com");
	Cliente c5 = new Cliente("12345678Z", "Zoe", "666666666", "zoe@gmail.com");
	

	@Test
	void testInsert() {	
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
	}

	@Test
	void testFindall() {
		fail("Not yet implemented");
	}

}
