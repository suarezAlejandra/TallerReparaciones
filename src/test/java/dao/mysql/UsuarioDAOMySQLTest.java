package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dao.interfaces.UsuarioDAO;
import entidades.Usuario;

class UsuarioDAOMySQLTest {

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	void testInsert() {
		Usuario u1 = new Usuario("12345678A", "alejandrasf", "alecontra", "mecanico");
		int resul = 0;
				
		// Crear usuarioDAO
		UsuarioDAO uDAO = new UsuarioDAOMySQL();
				
		// Llamar al insert de UsuarioDAO con el Usuario
		uDAO.insert(u1);
				
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testUpdate() {
		Usuario u2 = new Usuario("87654321B", "davideg", "davidyale", "admin");
		int resul = 0;
				
		// Crear usuarioDAO
		UsuarioDAO uDAO = new UsuarioDAOMySQL();
				
		// Llamar al insert de UsuarioDAO con el Usuario
		uDAO.insert(u2);
		
		// Ahora modifico el cliente 
		u2.setNombre_usuario("davideg20");
		
		// Actualizar cliente
		uDAO.update(u2);
		
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testDelete() {
		Usuario u3 = new Usuario("10002274C", "asgranda", "ASG", "mecanico");
		int resul = 0;
								
		// Crear usuarioDAO
		UsuarioDAO uDAO = new UsuarioDAOMySQL();
		
		// Insertar cliente
		uDAO.insert(u3);
		
		// Llamar al delete de ClienteDAO con el Cliente
		uDAO.delete(u3);
								
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testFindByNombreUsuario() {
		Usuario u1 = new Usuario("12345678A", "alejandrasf", "alecontra", "mecanico");
		Usuario u2 = new Usuario("87654321B", "davideg", "davidyale", "admin");
		Usuario u3 = new Usuario("10002274C", "asgranda", "ASG", "mecanico");
		Usuario u4 = new Usuario("17654221D", "mjosefl", "mariajota", "admin");
		Usuario u5 = new Usuario("56345656E", "zoees", "zoezoe", "mecanico");
		
		Usuario u = null;
		
		// Crear UsuarioDAO
		UsuarioDAO uDAO = new UsuarioDAOMySQL();
		
		// Insertar usuarios
		uDAO.insert(u1);
		uDAO.insert(u2);
		uDAO.insert(u3);
		uDAO.insert(u4);
		uDAO.insert(u5);
		
		uDAO.findByNombreUsuario("asgranda");
		
		// Comprobar
		assertEquals(u3, u);
	}

}
