package model;

import java.sql.Date;

public class IMC {
	
	private int id;
	private int idUsuario;
	private int estatura;
	private int peso;
	private double imc;
	private Date fecha;
	
	public IMC(String estatura, String peso) {
		this.estatura = Integer.parseInt(estatura);
		this.peso = Integer.parseInt(peso);
	}
	
	public IMC() {
	}
	
	public void calcularIMC() {
		double imc = this.peso / (this.estatura * this.estatura);
		this.setImc(imc);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
