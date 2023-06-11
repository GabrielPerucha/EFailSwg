package Combate;

import ClasesEntidades.Enemigo;
import ClasesEntidades.Jugable;
import Efectos.*;
import Movimientos.Ataque;
import Movimientos.Carta;

public class Terreno {

	protected Carta[] Mano;
	protected Carta[] Destierro;
	protected Carta[] Descartes;
	protected Carta[] MazoRestante;

	protected Jugable jugador;
	protected Enemigo e1, e2, e3;

	protected Efecto[] efectosEnEnemigo1;
	protected Efecto[] efectosEnEnemigo2;
	protected Efecto[] efectosEnEnemigo3;

	protected Efecto[] efectosEnJugador;

	public Efecto[] getEfectosEnJugador() {
		return efectosEnJugador;
	}

	public void setEfectosEnJugador(Efecto[] efectosEnJugador) {
		this.efectosEnJugador = efectosEnJugador;
	}

	public Efecto[] getEfectosEnEnemigo1() {
		return efectosEnEnemigo1;
	}

	public void setEfectosEnEnemigo1(Efecto[] efectosEnEnemigo1) {
		this.efectosEnEnemigo1 = efectosEnEnemigo1;
	}

	public Efecto[] getEfectosEnEnemigo2() {
		return efectosEnEnemigo2;
	}

	public void setEfectosEnEnemigo2(Efecto[] efectosEnEnemigo2) {
		this.efectosEnEnemigo2 = efectosEnEnemigo2;
	}

	public Efecto[] getEfectosEnEnemigo3() {
		return efectosEnEnemigo3;
	}

	public void setEfectosEnEnemigo3(Efecto[] efectosEnEnemigo3) {
		this.efectosEnEnemigo3 = efectosEnEnemigo3;
	}

	public Jugable getJugador() {
		return jugador;
	}

	public void setJugador(Jugable jugador) {
		this.jugador = jugador;
	}

	public Enemigo getE1() {
		return e1;
	}

	public void setE1(Enemigo e1) {
		this.e1 = e1;
	}

	public Enemigo getE2() {
		return e2;
	}

	public void setE2(Enemigo e2) {
		this.e2 = e2;
	}

	public Enemigo getE3() {
		return e3;
	}

	public void setE3(Enemigo e3) {
		this.e3 = e3;
	}

	public Carta[] getMano() {
		return Mano;
	}

	public void setMano(Carta[] mano) {
		Mano = mano;
	}

	public Carta[] getDestierro() {
		return Destierro;
	}

	public void setDestierro(Carta[] destierro) {
		Destierro = destierro;
	}

	public Carta[] getDescartes() {
		return Descartes;
	}

	public void setDescartes(Carta[] descartes) {
		Descartes = descartes;
	}

	public Carta[] getMazoRestante() {
		return MazoRestante;
	}

	public void setMazoRestante(Carta[] mazoRestante) {
		MazoRestante = mazoRestante;
	}

	/**
	 * 
	 * @param mano
	 * @param destierro
	 * @param descartes
	 * @param mazoRestante
	 * @param efectosEnJugador
	 * @param efectosEnEnemigo1
	 * @param jugador
	 * @param e1
	 */
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Efecto[] efectosEnJugador,
			Efecto[] efectosEnEnemigo1, Jugable jugador, Enemigo e1) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.efectosEnJugador = efectosEnJugador;
		this.efectosEnEnemigo1 = efectosEnEnemigo1;
		this.jugador = jugador;
		this.e1 = e1;
	}

	/**
	 * 
	 * @param mano
	 * @param destierro
	 * @param descartes
	 * @param mazoRestante
	 * @param efectosEnJugador
	 * @param efectosEnEnemigo1
	 * @param efectosEnEnemigo2
	 * @param jugador
	 * @param e1
	 * @param e2
	 */
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Efecto[] efectosEnJugador,
			Efecto[] efectosEnEnemigo1, Efecto[] efectosEnEnemigo2, Jugable jugador, Enemigo e1, Enemigo e2) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.efectosEnJugador = efectosEnJugador;
		this.efectosEnEnemigo1 = efectosEnEnemigo1;
		this.efectosEnEnemigo2 = efectosEnEnemigo2;
		this.jugador = jugador;
		this.e1 = e1;
		this.e2 = e2;
	}

	/**
	 * 
	 * @param mano
	 * @param destierro
	 * @param descartes
	 * @param mazoRestante
	 * @param efectosEnJugador
	 * @param efectosEnEnemigo1
	 * @param efectosEnEnemigo2
	 * @param efectosEnEnemigo3
	 * @param jugador
	 * @param e1
	 * @param e2
	 * @param e3
	 */
	public Terreno(Carta[] mano, Carta[] destierro, Carta[] descartes, Carta[] mazoRestante, Efecto[] efectosEnJugador,
			Efecto[] efectosEnEnemigo1, Efecto[] efectosEnEnemigo2, Efecto[] efectosEnEnemigo3, Jugable jugador,
			Enemigo e1, Enemigo e2, Enemigo e3) {
		super();
		Mano = mano;
		Destierro = destierro;
		Descartes = descartes;
		MazoRestante = mazoRestante;
		this.efectosEnJugador = efectosEnJugador;
		this.efectosEnEnemigo1 = efectosEnEnemigo1;
		this.efectosEnEnemigo2 = efectosEnEnemigo2;
		this.efectosEnEnemigo3 = efectosEnEnemigo3;
		this.jugador = jugador;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
	}

	public static Terreno terreno = new Terreno(null, null, null, null, null, null, null, null,
			new Jugable(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null),
			new Enemigo(null, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, new Ataque(null, "", 0, 0, null)), null, null);

}
