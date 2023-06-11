package ClasesEntidades;

public class Entidad {

	protected String Nombre;
	protected int vida;
	
	protected int nivel;
	
	protected int ataque;
	
	protected int defensa;
	protected int bloqueo;
	
	protected int probCritico;
	protected int danoCritico;
	
	
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getBloqueo() {
		return bloqueo;
	}
	public void setBloqueo(int bloqueo) {
		this.bloqueo = bloqueo;
	}
	public int getProbCritico() {
		return probCritico;
	}
	public void setProbCritico(int probCritico) {
		this.probCritico = probCritico;
	}
	public int getDanoCritico() {
		return danoCritico;
	}
	public void setDanoCritico(int danoCritico) {
		this.danoCritico = danoCritico;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param nivel
	 * @param vida
	 * @param ataque
	 * @param defensa
	 * @param probCritico
	 * @param danoCritico
	 * @param bloqueo
	 */
	public Entidad(String nombre, int nivel, int vida, int ataque, int defensa, int probCritico,
			int danoCritico, int bloqueo) {
		Nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.bloqueo = bloqueo;
		this.probCritico = probCritico;
		this.danoCritico = danoCritico;
		this.nivel = nivel;
	}
	
}
