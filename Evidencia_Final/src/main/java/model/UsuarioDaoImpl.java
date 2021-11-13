package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import repository.Conexion;

public class UsuarioDaoImpl implements UsuarioDAO{

	@Override
	public boolean registrar(Usuario usuario) {
		boolean registrar = false;
		Statement stm = null;
		Connection conn = null;
		
		String sql = "insert into evidenciafinal.person (name, last_name, edad, sexo, usuario, password)" + 
		             "values ('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getEdad() + "','" + usuario.getSexo() + "','" + usuario.getUsuario() + "','" + usuario.getPassword() + "')";
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo registrar el usuario");
			e.printStackTrace();
		}
		return registrar;
	}

	@Override
	public boolean validar(Usuario usuario) {
		boolean validar = false;
		Statement stm = null;
		Connection conn = null;
		
		String sql = "valid id_usuario from evidenciafinal.person where usuario = '" + usuario.getUsuario() + "'"; 
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			stm.execute(sql);
			stm.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar el nuevo usuario");
			e.printStackTrace();
		}	
		return validar;
	}

	@Override
	public Usuario consultar(Usuario usuario) {
		Statement stm = null;
		Connection conn = null;
		ResultSet rs = null;
		Usuario u = new Usuario();
		
		String sql = "Select id_usuario from evidenciafinal.person where usuario = '" + usuario.getUsuario() + "'";
		
		try {
			conn = Conexion.conectar();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				u.setId(rs.getInt(1));
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error: No se pudo validar si el usuario existe");
			e.printStackTrace();
		}		
		return u;
	}
}
