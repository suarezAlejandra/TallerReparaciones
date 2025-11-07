package dao.mysql;

import dao.interfaces.VehiculoDAO;

public class VehiculoDAOMySQL implements VehiculoDAO {
	int insert(Vehiculo v);
	int update(Vehiculo v);
	int delete(Vehiculo v);
	ArrayList<Vehiculo> findall();
	Cliente findByMatricula(String matricula);
}
