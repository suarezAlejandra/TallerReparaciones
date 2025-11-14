package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.interfaces.UsuarioDAO;
import entidades.Usuario;



class UsuarioDAOMySQLTest {

	@Test
	void testInsert() {
		// Crear usuario
		Usuario u = new Usuario("12345678A", "Alejandrasf", "contra", "mecanico");
				
		int resul = 0;
				
		// Crear UsuarioDAO
		UsuarioDAO uDAO = new UsuarioDAOMySQL();
				
		// Llamar al insert de ClienteDAO con el Cliente
		uDAO.insert(u);
				
		// Comprobar
		assertEquals(1, resul);
	}

}
