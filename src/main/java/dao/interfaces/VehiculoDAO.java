package dao.interfaces;

import java.util.ArrayList;
import entidades.Vehiculo;

public interface VehiculoDAO {
	int insert(Vehiculo v);
	int update(Vehiculo v);
	int delete(Vehiculo v);
	Vehiculo findByMatricula(String matricula);
	ArrayList<Vehiculo> findall();
}
