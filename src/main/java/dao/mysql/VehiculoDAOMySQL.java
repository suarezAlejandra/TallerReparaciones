package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.VehiculoDAO;
import entidades.Vehiculo;

public class VehiculoDAOMySQL implements VehiculoDAO {

private Connection conexion;
	
	public VehiculoDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	@Override
	public int insert(Vehiculo v) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			// PreparedStatement
			String sql = "INSERT INTO vehiculo (matricula, marca, modelo) VALUES(?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, v.getMatricula());
			pst.setString(2, v.getMarca());
			pst.setString(3, v.getModelo());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int update(Vehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Vehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehiculo findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vehiculo> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
