package model;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String sexo;
	private String usuario;
	private String password;
	
	public Usuario(String nombre, String apellido, String edad, String sexo, String usuario, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = Integer.parseInt(edad);
		this.sexo = sexo;
		this.usuario = usuario;
		this.password = password;
	}
	
	public Usuario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
