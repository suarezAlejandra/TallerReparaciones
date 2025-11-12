package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

	@Test
	void test() {
		DBConnection conexion1 = DBConnection.getInstance();
		DBConnection conexion2 = DBConnection.getInstance();
		
		assertEquals(conexion1, conexion2);
	}

}
