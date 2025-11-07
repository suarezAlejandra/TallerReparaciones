package dao.mysql;

import dao.interfaces.ReparacionDAO;

public class ReparacionDAOMySQL implements ReparacionDAO {
	int insert(Reparacion r);
	int update(Reparacion r);
	int delete(Reparacion r);
	ArrayList<Reparacion> findall();
	Reparacion findById(int id);
}
