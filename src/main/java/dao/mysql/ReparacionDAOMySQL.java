package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.ReparacionDAO;
import entidades.Cliente;
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
		int resul = 0;
		try {
			String sql = "UPDATE reparacion SET descripcion = ?, fecha_entrada = ?, coste_estimado = ?, estado = ? WHERE id_reparacion = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, r.getDescripcion());
			pst.setDate(2, r.getFecha_entrada());
			pst.setFloat(3, r.getCoste_estimado());
			pst.setString(4,  r.getEstado());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la actualización: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public int delete(Reparacion r) {
		// TODO Auto-generated method stub
		int resul = 0;
		try {
			String sql = "DELETE FROM reparacion WHERE id_reparacion = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			//pst.setInt(1, c.getId_reparacion());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado del borrado: " + resul);
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return resul;
	}

	@Override
	public Reparacion findById(int id) {
		// TODO Auto-generated method stub
		Reparacion r = null;
		try {
			String sql = "SELECT * FROM reparacion WHERE id_reparacion = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			//pst.setString(1, id_reparacion);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada"),
						resul.getFloat("coste_estimado"),
						resul.getString("estado")
						);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return r;
	}

	@Override
	public ArrayList<Reparacion> findall() {
		// TODO Auto-generated method stub
		ArrayList<Reparacion> reparaciones = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reparacion ORDER BY id_reparacion;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			ResultSet resul = pst.executeQuery();
			
			while (resul.next()) {
				Reparacion r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada"),
						resul.getFloat("coste_estimado"),
						resul.getString("estado")
						);
				reparaciones.add(r);
			}
		} catch (SQLException e) {
			System.out.println("> NOK: " + e.getMessage());
		}
		return reparaciones;
	}

}
