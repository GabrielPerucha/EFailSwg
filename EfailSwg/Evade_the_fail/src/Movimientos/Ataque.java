package Movimientos;

import Efectos.*;

public class Ataque extends Movimiento{

	protected int probabilidad;
	protected int potencia;
	protected Efecto[] efectos;
	protected EfectoEspecial efectoEspecial;
	
	
	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getProbabilidad() {
		return probabilidad;
	}
	
	public Efecto[] getEfectos() {
		return efectos;
	}

	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	public EfectoEspecial getEfectoEspecial() {
		return efectoEspecial;
	}

	public void setEfectoEspecial(EfectoEspecial efectoEspecial) {
		this.efectoEspecial = efectoEspecial;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 * @param probabilidad
	 * @param potencia
	 * @param efectos
	 */
	public Ataque(String descripcion, String nombre, int probabilidad, int potencia, Efecto[] efectos) {
		super(descripcion, nombre);
		this.probabilidad = probabilidad;
		this.potencia = potencia;
		this.efectos = efectos;
	}

	/**
	 * 
	 * @param descripcion
	 * @param nombre
	 * @param probabilidad
	 * @param potencia
	 * @param efectos
	 * @param efectoEspecial
	 */
	public Ataque(String descripcion, String nombre, int probabilidad, int potencia, Efecto[] efectos,
			EfectoEspecial efectoEspecial) {
		super(descripcion, nombre);
		this.probabilidad = probabilidad;
		this.potencia = potencia;
		this.efectos = efectos;
		this.efectoEspecial = efectoEspecial;
	}

	
	
	//Falta la creación de ataques y ver dónde se crean.
}
