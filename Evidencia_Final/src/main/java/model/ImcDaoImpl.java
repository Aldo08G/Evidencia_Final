package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import repository.Conexion;

public class ImcDaoImpl implements ImcDAO{

	@Override
	public IMC verHistorico(IMC imc) {
		Statement stm = null;
		Connection conn = null;
		ResultSet rs = null;
		IMC i = new IMC();
		
		String sql = "Select id_imc from evidenciafinal.imc where imc = '" + imc.getImc() + "'";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				i.setId(rs.getInt(1));
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar si el IMC se calculo");
			e.printStackTrace();
		}		
		return i;
	}

	@Override
	public boolean registrarImc(IMC imc) {
		boolean registrarImc = false;
		Statement stm = null;
		Connection conn = null;
		
		String sql = "insert into evidenciafinal.imc (id_usuario, peso, estatura, imc, fecha)" + 
		             "values ('" + imc.getIdUsuario() + "','" + imc.getPeso() + "','" + imc.getEstatura() + "','" + imc.getImc() + "','" + imc.getFecha() + "')";
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			stm.execute(sql);
			registrarImc = true;
			stm.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo registrar el IMC");
			e.printStackTrace();
		}
		return registrarImc;
	}
}
