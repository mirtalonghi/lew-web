package config;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author MyL
 */
public class Conexion {

	public static void main(String[] args) throws SQLException {
		System.out.println("Prueba de Ingreso de Datos");

		// Consultar Datos
		conectarBaseDeDatos();

	}

	private static Connection conectarBaseDeDatos() throws SQLException {
		Connection conexion = null;
		try {
		    conexion =
		       DriverManager.getConnection("jdbc:mysql://localhost:3306/lew?" +
		                                   "user=root&password=");

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

		return conexion;
	}

	private static void consultar() {
		try {
			Connection conexion = conectarBaseDeDatos();
			String sql = "select * from autofamiliar";
			Statement querry = conexion.createStatement();
			ResultSet resultado = querry.executeQuery(sql);

			System.out.println("Inicio");

			while (resultado.next()) {
				System.out.println(resultado.getString("patenteNumero") + "|");
				System.out.println(resultado.getBoolean("patenteActiva") + "|");
				System.out.println(resultado.getString("marca") + "|");
				System.out.println(resultado.getString("categoria") + "|");
				System.out.println(resultado.getString("color") + "|");
			}

			System.out.println("Fin");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
