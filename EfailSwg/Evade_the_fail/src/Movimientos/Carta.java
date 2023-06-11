package Movimientos;

import java.util.ArrayList;
import java.util.Iterator;

import ClasesEntidades.Enemigo;
import Combate.*;
import Efectos.*;

public class Carta extends Movimiento {

	// TO DO Creacion de cartas y establecer cuántas habrá y de que clase

	protected String elemento;
	protected int coste;
	protected String clase;
	protected int ID;
	protected Efecto[] efectos;

	public Efecto[] getEfectos() {
		return efectos;
	}

	public void setEfectos(Efecto[] efectos) {
		this.efectos = efectos;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * 
	 * @param ID
	 * @param nombre
	 * @param descripcion
	 * @param elemento
	 * @param coste
	 * @param clase
	 * @param efectos
	 */
	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
			Efecto[] efectos) {
		super(descripcion, nombre);
		this.ID = ID;
		this.efectos = efectos;
		this.elemento = elemento;
		this.coste = coste;
		this.clase = clase;
	}

	/**
	 * 
	 * @param carta
	 * @param objetivo
	 */
	public static int ejecutarCarta(Carta carta, int objetivo) {

		int danoTotal = 0;
		
		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < carta.getEfectos().length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {
				
				EfectoSobreEstadisticas efecto = new EfectoSobreEstadisticas((EfectoSobreEstadisticas) carta.getEfectos()[i]);

				nfx.add((EfectoSobreEstadisticas) efecto);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) carta.getEfectos()[i]);

			}

		}

		// A partir de aquí sí ejecutamos los efectos como tal

		// Recorrer los efectos normales
		for (int i = 0; i < nfx.size(); i++) {

			// Si el objetivo del efecto eres tú:
			if (nfx.get(i).isObjetivo()) {

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador()
								.setAtaque((int) (Terreno.terreno.getJugador().getAtaque() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "defensa":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador()
								.setDefensa((int) (Terreno.terreno.getJugador().getDefensa() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "Mana":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador()
								.setMana((int) (Terreno.terreno.getJugador().getMana() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador()
								.setVida((int) (Terreno.terreno.getJugador().getVida() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador().setVidaRestante(
								(int) (Terreno.terreno.getJugador().getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "manaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador().setManaRestante(
								(int) (Terreno.terreno.getJugador().getManaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "bloqueo":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador()
								.setBloqueo((int) (Terreno.terreno.getJugador().getBloqueo() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador().setProbCritico(
								(int) (Terreno.terreno.getJugador().getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador().setDanoCritico(
								(int) (Terreno.terreno.getJugador().getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);

						Terreno.terreno.setEfectosEnJugador(efectosEnJug);

					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {

						Terreno.terreno.getJugador().setVidaRestante(
								(int) (Terreno.terreno.getJugador().getVidaRestante() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));


					} else {

						Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

						for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

							efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

						}

						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
						
					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:

					Combate.aplicaEfectosEspeciales(nfx.get(i).getEstadistica());
					
					Efecto[] efectosEnJug = new Efecto[Terreno.terreno.getEfectosEnJugador().length + 1];

					for (int j = 0; j < Terreno.terreno.getEfectosEnJugador().length; j++) {

						efectosEnJug[j] = Terreno.terreno.getEfectosEnJugador()[j];

					}

					efectosEnJug[Terreno.terreno.getEfectosEnJugador().length] = nfx.get(i);
					Terreno.terreno.setEfectosEnJugador(efectosEnJug);

				}

				// Si el objetivo del efecto es el enemigo
			} else {

				Enemigo enemigoAfectado;
				Efecto[] efectosDelEnemigo;

				switch (objetivo) {

				case 1:
					enemigoAfectado = Terreno.terreno.getE1();
					efectosDelEnemigo = Terreno.terreno.getEfectosEnEnemigo1();
					break;
				case 2:
					enemigoAfectado = Terreno.terreno.getE2();
					efectosDelEnemigo = Terreno.terreno.getEfectosEnEnemigo2();

					break;
				case 3:
					enemigoAfectado = Terreno.terreno.getE3();
					efectosDelEnemigo = Terreno.terreno.getEfectosEnEnemigo3();

					break;
				default:
					//Inicializar variables aquí para evitar que el programa pete
					enemigoAfectado = Terreno.terreno.getE1();
					efectosDelEnemigo = Terreno.terreno.getEfectosEnEnemigo1();
				}

				switch (nfx.get(i).getEstadistica()) {

				case "ataque":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setAtaque((int) (enemigoAfectado.getAtaque() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
						
					}

					break;
				
				case "defensa":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setDefensa((int) (enemigoAfectado.getDefensa() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "vida":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setVida((int) (enemigoAfectado.getVida() * nfx.get(i).getMultiplicador()
								+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "vidaRestante":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado.setVidaRestante((int) (enemigoAfectado.getVidaRestante()
								+ enemigoAfectado.getVida() * nfx.get(i).getMultiplicador() + nfx.get(i).getSumador()));


					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "probCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado
								.setProbCritico((int) (enemigoAfectado.getProbCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "danoCritico":

					if (nfx.get(i).getRetardo() == 0) {

						enemigoAfectado
								.setDanoCritico((int) (enemigoAfectado.getDanoCritico() * nfx.get(i).getMultiplicador()
										+ nfx.get(i).getSumador()));

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}

						efectosAux[efectosDelEnemigo.length] = nfx.get(i);

						efectosDelEnemigo = efectosAux;

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				case "dano":

					if (nfx.get(i).getRetardo() == 0) {
						
						if (Combate.afinidadCorrecta(carta, enemigoAfectado))
							nfx.get(i).setMultiplicador(nfx.get(i).getMultiplicador()+0.5);
						
						danoTotal += Combate.dañarEnemigo(objetivo, nfx.get(i).getMultiplicador(), nfx.get(i).getSumador());

					} else {

						Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

						for (int j = 0; j < efectosDelEnemigo.length; j++) {

							efectosAux[j] = efectosDelEnemigo[j];

						}
						
						nfx.get(i).setRetardo(nfx.get(i).getRetardo()-1);
						efectosAux[efectosDelEnemigo.length] = nfx.get(i);
					}

					break;

				// Este caso se trata de un efecto "trait" que pondría al jugador una etiqueta,
				// es un tipo de efecto especial por programar
				default:
					
					Combate.aplicaEfectosEspeciales(nfx.get(i).getEstadistica());
					Efecto[] efectosAux = new Efecto[efectosDelEnemigo.length + 1];

					for (int j = 0; j < efectosDelEnemigo.length; j++) {

						efectosAux[j] = efectosDelEnemigo[j];

					}

					efectosAux[efectosDelEnemigo.length] = nfx.get(i);

				}

				switch (objetivo) {

				case 1:
					Terreno.terreno.setE1(enemigoAfectado);
					Terreno.terreno.setEfectosEnEnemigo1(efectosDelEnemigo);
					break;
				case 2:
					Terreno.terreno.setE1(enemigoAfectado);
					Terreno.terreno.setEfectosEnEnemigo1(efectosDelEnemigo);

					break;
				case 3:
					Terreno.terreno.setE1(enemigoAfectado);
					Terreno.terreno.setEfectosEnEnemigo1(efectosDelEnemigo);

					break;
				
				default:
						

				}
			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			Carta cartaAux = new Carta(-1, "CartaAuxiliar", spfx.get(i).getDescripcion(), carta.getElemento(), 0,
					carta.getClase(), efectosAux);

			/*
			 * Esta sentencia recursiva vuelve a llamar al metodo de ejecutar carta, que al
			 * principio separa los efectos especiales de los normales
			 */
			danoTotal += ejecutarCarta(cartaAux, objetivo);

		}

		return danoTotal;
		
	}

}
