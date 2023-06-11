package Efectos;

public class EfectoSobreEstadisticas extends Efecto{
	
	/*
	 * Los efectos pueden aplicar un multiplicador, un sumador o ambas, por eso tienen tres constructores	
	 */
	
	protected double multiplicador;
	protected int sumador;
	protected int duracion;
	protected boolean objetivo;
	protected int retardo;
	protected String estadistica;
	
	
	public int getRetardo() {
		return retardo;
	}

	public void setRetardo(int retardo) {
		this.retardo = retardo;
	}

	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

	public int getSumador() {
		return sumador;
	}

	public void setSumador(int sumador) {
		this.sumador = sumador;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isObjetivo() {
		return objetivo;
	}

	public void setObjetivo(boolean objetivo) {
		this.objetivo = objetivo;
	}

	public String getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(String estadistica) {
		this.estadistica = estadistica;
	}

	/**
	 * 
	 * @param estadistica
	 * @param multiplicador
	 * @param sumador
	 * @param duracion
	 * @param retardo
	 * @param objetivo
	 */
	public EfectoSobreEstadisticas(String estadistica, double multiplicador, int sumador, int duracion, int retardo, boolean objetivo) {
		this.multiplicador = multiplicador;
		this.sumador = sumador;
		this.duracion = duracion;
		this.objetivo = objetivo;
		this.retardo = retardo;
		this.estadistica = estadistica;
	}

	public EfectoSobreEstadisticas(EfectoSobreEstadisticas efectos) {
		this.multiplicador = efectos.getMultiplicador();
		this.sumador = efectos.getSumador();
		this.duracion = efectos.getDuracion();
		this.objetivo = efectos.isObjetivo();
		this.retardo = efectos.getRetardo();
		this.estadistica = efectos.getEstadistica();
	}
	
	//TO DO Programar más efectos y sus consecuencias una vez sea posible su comprobación.
	
}
