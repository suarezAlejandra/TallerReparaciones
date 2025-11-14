package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.ReparacionDAO;
import entidades.Reparacion;

public class ReparacionDAOMySQL implements ReparacionDAO {

	private Connection conexion;
	
	public ReparacionDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	@Override
	public int insert(Reparacion r) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "INSERT INTO reparacion (descripcion, fecha_entrada, coste_estimado, estado) VALUES(?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, r.getDescripcion());
			pst.setDate(2, r.getFecha_entrada());
			pst.setFloat(3, r.getCoste_estimado());
			pst.setString(4, r.getEstado());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int update(Reparacion r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Reparacion r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reparacion findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reparacion> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
