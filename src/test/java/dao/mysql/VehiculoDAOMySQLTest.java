package dao.mysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dao.interfaces.UsuarioDAO;
import dao.interfaces.VehiculoDAO;
import entidades.Usuario;
import entidades.Vehiculo;

class VehiculoDAOMySQLTest {

	

	@Test
	void testInsert() {
		Vehiculo v1 = new Vehiculo("2345JNH", "Hyundai", "i30");
		int resul = 0;
				
		// Crear usuarioDAO
		VehiculoDAO vDAO = new VehiculoDAOMySQL();
				
		// Llamar al insert de UsuarioDAO con el Usuario
		vDAO.insert(v1);
				
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testUpdate() {
		Vehiculo v2 = new Vehiculo("5685TCH", "Seat", "Ibiza");
		int resul = 0;
				
		// Crear usuarioDAO
		VehiculoDAO vDAO = new VehiculoDAOMySQL();
				
		// Llamar al insert de UsuarioDAO con el Usuario
		vDAO.insert(v2);
		
		// Ahora modifico el cliente 
		v2.setModelo("Leon");
		
		// Actualizar cliente
		vDAO.update(v2);
		
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testDelete() {
		Vehiculo v3 = new Vehiculo("3573ERF", "Ford", "Fiesta");
		int resul = 0;
								
		// Crear usuarioDAO
		VehiculoDAO vDAO = new VehiculoDAOMySQL();
		
		// Insertar cliente
		vDAO.insert(v3);
		
		// Llamar al delete de ClienteDAO con el Cliente
		vDAO.delete(v3);
								
		// Comprobar
		assertEquals(1, resul);
	}

	@Test
	void testFindByMatricula() {
		Vehiculo v1 = new Vehiculo("2345JNH", "Hyundai", "i30");
		Vehiculo v2 = new Vehiculo("5685TCH", "Seat", "Ibiza");
		Vehiculo v3 = new Vehiculo("3573ERF", "Ford", "Fiesta");
		Vehiculo v4 = new Vehiculo("4383OTY", "Ford", "Ecosport");
		Vehiculo v5 = new Vehiculo("1286TPP", "Peugeot", "407");
		
		Vehiculo v = null;
		
		// Crear UsuarioDAO
		VehiculoDAO vDAO = new VehiculoDAOMySQL();
		
		// Insertar usuarios
		vDAO.insert(v1);
		vDAO.insert(v2);
		vDAO.insert(v3);
		vDAO.insert(v4);
		vDAO.insert(v5);
		
		vDAO.findByMatricula("4383OTY");
		
		// Comprobar
		assertEquals(v4, v);
	}

	@Test
	void testFindall() {
		fail("Not yet implemented");
	}

}
