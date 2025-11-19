package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			pst.setDate(2, java.sql.Date.valueOf(r.getFecha_entrada()));
			pst.setDouble(3, r.getCoste_estimado());
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
			// PreparedStatement
			String sql = "UPDATE reparacion SET descripcion = ?, fecha_entrada = ?, coste_estimado = ?, estado = ? WHERE id_reparacion = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Introducir datos
			pst.setString(1, r.getDescripcion());
			pst.setDate(2, java.sql.Date.valueOf(r.getFecha_entrada()));
			pst.setDouble(3, r.getCoste_estimado());
			pst.setString(4, r.getEstado());
			pst.setInt(5,  r.getId_reparacion());
			
			resul = pst.executeUpdate();
			System.out.println("> Resultado de la inserción: " + resul);
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
			
			pst.setInt(1, r.getId_reparacion());
			
			resul = pst.executeUpdate();
			
			if (resul == 1) {
				System.out.println("> OK: Reparación con ID " + r.getId_reparacion() + " eliminada correctamente.");
			} else {
				System.out.println("> NOK: Reparación con ID " + r.getId_reparacion() + " no se encuentra en la base de datos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			
			pst.setInt(1, id);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada").toLocalDate(),
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
			String sql = "SELECT * FROM reparacion;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			ResultSet resul = pst.executeQuery();
			
			while (resul.next()) {
				Reparacion r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada").toLocalDate(),
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

	@Override
	public ArrayList<Reparacion> findByFechaEntrada(LocalDate fecha) {
		// TODO Auto-generated method stub
		ArrayList<Reparacion> reparacionesPorFecha = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reparacion ORDER BY fecha_entrada;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				Reparacion r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada").toLocalDate(),
						resul.getFloat("coste_estimado"),
						resul.getString("estado")
						);
				reparacionesPorFecha.add(r);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return reparacionesPorFecha;
	}

	@Override
	public ArrayList<Reparacion> findByEstado(String estado) {
		// TODO Auto-generated method stub
		ArrayList<Reparacion> reparacionesPorEstado = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reparacion WHERE estado = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1,  estado);
			
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				Reparacion r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada").toLocalDate(),
						resul.getFloat("coste_estimado"),
						resul.getString("estado")
						);
				reparacionesPorEstado.add(r);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return reparacionesPorEstado;
	}

	@Override
	public ArrayList<Reparacion> findByCosteMedio(double coste) {
		// TODO Auto-generated method stub
		ArrayList<Reparacion> reparacionesPorCoste = new ArrayList<>();
		try {
			String sql = "SELECT * FROM reparacion ORDER BY coste_estimado;";
			PreparedStatement pst = conexion.prepareStatement(sql);
						
			ResultSet resul = pst.executeQuery();
			
			if (resul.next()) {
				Reparacion r = new Reparacion(
						resul.getString("descripcion"),
						resul.getDate("fecha_entrada").toLocalDate(),
						resul.getFloat("coste_estimado"),
						resul.getString("estado")
						);
				reparacionesPorCoste.add(r);
			}
		} catch (SQLException e) {
			System.out.println(">NOK: " + e.getMessage());
		}
		return reparacionesPorCoste;
	}

}
