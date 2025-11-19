package dao.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import entidades.Reparacion;

public interface ReparacionDAO {
	int insert(Reparacion r);
	int update(Reparacion r);
	int delete(Reparacion r);
	Reparacion findById(int id);
	ArrayList<Reparacion> findall();
	
	ArrayList<Reparacion> findByFechaEntrada(LocalDate fecha);
	ArrayList<Reparacion> findByEstado(String estado);
	ArrayList<Reparacion> findByCosteMedio(double coste);
}
