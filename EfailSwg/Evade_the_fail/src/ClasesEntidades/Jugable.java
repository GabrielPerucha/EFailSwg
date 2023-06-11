package ClasesEntidades;

import javax.swing.Icon;

import Efectos.Efecto;
import Movimientos.Carta;

public class Jugable extends Entidad {

	/*
	 * TO DO Creación de clases hijas con diferentes estilos de personajes
	 */

	protected int mana;
	protected int manaRestante;
	protected String clase;
	protected Icon iconoJugador;
	protected Carta[] Mazo;
	protected int vidaRestante;
	protected Efecto[] pasivas;
	
	
	public Efecto[] getPasivas() {
		return pasivas;
	}

	public void setPasivas(Efecto[] pasivas) {
		this.pasivas = pasivas;
	}

	public int getManaRestante() {
		return manaRestante;
	}

	public void setManaRestante(int manaRestante) {
		this.manaRestante = manaRestante;
	}

	public int getVidaRestante() {
		return vidaRestante;
	}

	public void setVidaRestante(int vidaRestante) {
		this.vidaRestante = vidaRestante;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Icon getIconoJugador() {
		return iconoJugador;
	}

	public void setIconoJugador(Icon iconoJugador) {
		this.iconoJugador = iconoJugador;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Carta[] getMazo() {
		return Mazo;
	}

	public void setMazo(Carta[] mazo) {
		Mazo = mazo;
	}

	/**
	 * 
	 * @param nombre
	 * @param nivel
	 * @param vida
	 * @param vidaRestante
	 * @param ataque
	 * @param defensa
	 * @param probCritico
	 * @param danoCritico
	 * @param bloqueo
	 * @param mana
	 * @param manaRestante
	 * @param clase
	 * @param iconoJugador
	 * @param mazo
	 * @param pasivas
	 */
	public Jugable(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int probCritico, int danoCritico,
			int bloqueo, int mana, int manaRestante, String clase, Icon iconoJugador, Carta[] mazo, Efecto[] pasivas) {
		super(nombre, nivel, vida, ataque, defensa, probCritico, danoCritico, bloqueo);
		this.mana = mana;
		this.manaRestante = manaRestante;
		this.clase = clase;
		this.iconoJugador = iconoJugador;
		this.Mazo = mazo;
		this.vidaRestante = vidaRestante;
		this.pasivas = pasivas;
	}

	public Jugable (Jugable jugador) {
		super(jugador.getNombre(), jugador.getNivel(), jugador.getVida(), jugador.getAtaque(), jugador.getDefensa(), jugador.getProbCritico(), jugador.getDanoCritico(), jugador.getBloqueo());
		this.mana = jugador.getMana();
		this.manaRestante = jugador.getManaRestante();
		this.clase = jugador.getClase();
		this.iconoJugador = jugador.getIconoJugador();
		this.Mazo = jugador.getMazo();
		this.vidaRestante = jugador.getVidaRestante();
		this.pasivas = jugador.getPasivas();
	}

}
