package Efectos;

public class EfectoEspecial extends Efecto{
	
	protected String descripcion;
	protected EfectoSobreEstadisticas[] efectos;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EfectoSobreEstadisticas[] getEfectos() {
		return efectos;
	}
	public void setEfectos(EfectoSobreEstadisticas[] efectos) {
		this.efectos = efectos;
	}
	
	/**
	 * 
	 * @param descripcion
	 * @param efectos
	 */
	public EfectoEspecial(String descripcion, EfectoSobreEstadisticas[] efectos) {
		this.descripcion = descripcion;
		this.efectos = efectos;
	}
	
}
