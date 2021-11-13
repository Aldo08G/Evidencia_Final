package model;

public interface UsuarioDAO {
	
	public boolean registrar(Usuario usuario);
	public boolean validar(Usuario usuario);
	public Usuario consultar(Usuario usuario);
}
	