package Combate;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Efectos.*;
import Movimientos.*;
import Partida.Interfaz;

//String[] opciones = new String[] {};

//int eleccion = JOptionPane.showOptionDialog(null, "Contenido", "Título", 0, 0, null, opciones, "Preseleccionado");

public class Combate {
	
	public static boolean golpeCritico = false;
	public static boolean enemigoClave = false;

	/*
	 * Hay dos metodos de dano, uno para cuando el jugador ataca y otro para cuando
	 * defiende. Esto se debe al equilibrio entre el jugador y los enemigos, para
	 * poder utilizar una escala de estadisticas lógica y reducir el dano que hace
	 * el enemigo al jugador.
	 */

	public static boolean afinidadCorrecta(Carta cartaUsada, Enemigo objetivo) {
		
		boolean esEficaz = false;
		
		switch (cartaUsada.getElemento()) {
		
		case "Neutro":
			
			if (objetivo.getElemento().equals("Vacío"))
				esEficaz = true;
			
			break;
		
		case "Naturaleza":
			
			if (objetivo.getElemento().equals("Divinidad"))
				esEficaz = true;
			
			break;
		
		case "Destrucción":
			
			if (objetivo.getElemento().equals("Naturaleza"))
				esEficaz = true;
			
			break;
		
		case "Divinidad":
			
			if (objetivo.getElemento().equals("Destrucción"))
				esEficaz = true;
			
			break;
		
		case "Vacío":
			
			if (!objetivo.getElemento().equals("Neutro"))
				esEficaz = true;
			
			break;
		
		}
		
		
		return esEficaz;
		
	}
	
	/**
	 * 
	 * @param objetivo
	 * @param atacante
	 * @return
	 */
	public static int formulaDano(Jugable atacante, int objetivo) {

		int total;

		Enemigo NPC = null;

		switch (objetivo) {

		case 1:
			NPC = Terreno.terreno.getE1();
			break;
		case 2:
			NPC = Terreno.terreno.getE2();
			break;
		case 3:
			NPC = Terreno.terreno.getE3();
			break;
		}

		total = (int) (Math.sqrt(atacante.getAtaque()) + (((atacante.getAtaque() + atacante.getAtaque())- NPC.getDefensa() + 1) / (NPC.getDefensa()*0.1 + 1)) - NPC.getBloqueo());
		
		if (Math.random()*100.99 < atacante.getProbCritico()) {
			total += total * atacante.getDanoCritico()/100;
			golpeCritico = true;
		}

		if (NPC.getBloqueo() >= total) {
			NPC.setBloqueo(NPC.getBloqueo() - total);
		} else {
			total = total - NPC.getBloqueo();
			NPC.setBloqueo(0);
		}
		switch (objetivo) {

		case 1:
			Terreno.terreno.setE1(NPC);
			break;
		case 2:
			Terreno.terreno.setE2(NPC);
			break;
		case 3:
			Terreno.terreno.setE3(NPC);
			break;
		}

		return total;

	}

	/**
	 * 
	 * @param atacante
	 * @param objetivo
	 * @return
	 */
	public static int formulaDanoRival(Enemigo atacante, Jugable objetivo) {

		int total;

		total = (int) (atacante.getSiguienteAccion().getPotencia() / 100 * Math.sqrt(atacante.getAtaque())
				+ (((atacante.getAtaque() + atacante.getAtaque())-objetivo.getDefensa() + 1) / (objetivo.getDefensa()/10 + 1)));

		if (Math.random()*100.99 < atacante.getProbCritico()) {
			total += total * atacante.getDanoCritico()/100;
			golpeCritico = true;
		}
		
		if (objetivo.getBloqueo() >= total) {
			Terreno.terreno.getJugador().setBloqueo(Terreno.terreno.getJugador().getBloqueo() - total);
			total = 0;
		} else {
			total -= Terreno.terreno.getJugador().getBloqueo();
			Terreno.terreno.getJugador().setBloqueo(0);
		}

		return total;

	}

	/**
	 * 
	 * @param mazo
	 * @return
	 */
	public static Carta[] barajeo(Carta[] mazo) {

		Carta[] mazoAux = new Carta[mazo.length];
		int[] comprobados = new int[mazo.length];
		boolean estaRepartido = false;

		for (int i = 0; i < mazoAux.length; i++) {

			estaRepartido = false;

			int num = (int) (Math.random() * (mazo.length + 0.99));

			for (int j = 0; j < comprobados.length; j++) {

				if (num == comprobados[j]) {
					estaRepartido = true;

				}
			}

			if (!estaRepartido) {

				mazoAux[i] = mazo[num - 1];
				comprobados[i] = num;

			} else {

				i--;
			}

		}
		return mazoAux;

	}

	/**
	 * 
	 * @param efectos
	 * @return
	 */

	public static EfectoSobreEstadisticas[] castEfectos(Efecto[] efectos) {

		// nfx = normal effects
		ArrayList<EfectoSobreEstadisticas> nfx = new ArrayList<EfectoSobreEstadisticas>();

		// spfx = special effects
		ArrayList<EfectoEspecial> spfx = new ArrayList<EfectoEspecial>();

		for (int i = 0; i < efectos.length; i++) {

			/*
			 * El array de efectos de la carta almacena "Efecto", no
			 * "EfectoSobreEstadisticas" ni "EfectoEspecial". para poder llamarlos y ver su
			 * efecto real hubo que hacer dos arrayList y utilizar el try catch de if else.
			 * Si lanza una excepción es porque el cast no funcionó, por lo que no se trata
			 * de un EfectoSobreEstadisticas, sino de uno especial
			 */
			try {

				nfx.add((EfectoSobreEstadisticas) efectos[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) efectos[i]);

			}

		}

		for (int i = 0; i < spfx.size(); i++) {

			Efecto efectosAux[] = spfx.get(i).getEfectos();

			for (int j = 0; j < spfx.get(i).getEfectos().length; j++) {

				nfx.add(castEfectos(efectosAux)[j]);
			}
		}

		EfectoSobreEstadisticas[] efectosTotales = new EfectoSobreEstadisticas[nfx.size()];

		for (int i = 0; i < nfx.size(); i++) {

			efectosTotales[i] = nfx.get(i);

		}

		return efectosTotales;

	}

	/**
	 * 
	 * @param carta
	 * @return
	 */
	public static boolean puedeElegirRival(Carta carta) {

		boolean sePuedeElegirRival = false;

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

				nfx.add((EfectoSobreEstadisticas) carta.getEfectos()[i]);

			} catch (Exception e) {

				spfx.add((EfectoEspecial) carta.getEfectos()[i]);

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

			if (puedeElegirRival(cartaAux))
				sePuedeElegirRival = true;

		}

		for (int i = 0; i < nfx.size(); i++) {

			if (!nfx.get(i).isObjetivo())
				sePuedeElegirRival = true;

		}

		return sePuedeElegirRival;

	}

	/**
	 * 
	 * @param Terreno.terreno
	 * @param enemigoAtacante
	 * @return
	 */
	public static Ataque eleccionSiguienteAccion(int enemigoAtacante) {

		int ataqueEnemigo;
		int[] probabilidades = new int[100];

		ataqueEnemigo = (int) (Math.random() * 99.99);

		Ataque ataqueEjecutado = new Ataque(null, null, ataqueEnemigo, ataqueEnemigo, null);

		switch (enemigoAtacante) {

		case 1:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = i;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		case 2:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++, k++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = j;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		case 3:
			for (int i = 0, k = 0; i < Terreno.terreno.getE1().getAtaques().length; i++, k++) {

				for (int j = 0; j < Terreno.terreno.getE1().getAtaques()[i].getProbabilidad(); j++, k++) {

					probabilidades[k] = j;

				}

			}
			ataqueEjecutado = Terreno.terreno.getE1().getAtaques()[probabilidades[ataqueEnemigo]];
			break;

		}

		return ataqueEjecutado;

	}

	/**
	 * 
	 * @param NPC
	 */
	public static int inicioCombate(Enemigo NPC, Jugable jugador) {

		int nivelEnemigo = NPC.getNivel();
		if (NPC.getNivel() == 1) {
		nivelEnemigo = jugador.getNivel() + (int) (Math.random() * 4.99 - 3);
			NPC.setNivel(nivelEnemigo);
		} else {
			enemigoClave = true;
		}

		JOptionPane.showMessageDialog(null, "¡Ha aparecido un " + NPC.getNombre() + " de nivel " + NPC.getNivel() + "!",
				"¡Encuentro!", 0, NPC.getIconoEnemigo());

		return nivelEnemigo;
		
	}

	public static int dañarEnemigo(int objetivo, double multiplicador, int sumador) {

		Enemigo enemigoAux = null;

		switch (objetivo) {

		case 1:
			enemigoAux = Terreno.terreno.getE1();
			break;
		case 2:
			enemigoAux = Terreno.terreno.getE2();
			break;
		case 3:
			enemigoAux = Terreno.terreno.getE3();
			break;
		}

		int total = (int) (Combate.formulaDano(Terreno.terreno.getJugador(), objetivo) * multiplicador + sumador);

		enemigoAux.setVidaRestante(enemigoAux.getVidaRestante() - total);

		switch (objetivo) {

		case 1:
			Terreno.terreno.setE1(enemigoAux);
			break;
		case 2:
			Terreno.terreno.setE2(enemigoAux);
			break;
		case 3:
			Terreno.terreno.setE3(enemigoAux);
			break;
		}

		return total;
	}

	public static int dañarJugador(Enemigo atacante) {

		int total = Combate.formulaDanoRival(atacante, Terreno.terreno.getJugador());

		Terreno.terreno.getJugador().setVidaRestante(Terreno.terreno.getJugador().getVidaRestante() - total);

		return total;

	}

	public static void revisaEfectosJugador(Jugable jugador) {

		Terreno.terreno.getJugador().setAtaque(jugador.getAtaque());
		Terreno.terreno.getJugador().setDefensa(jugador.getDefensa());
		Terreno.terreno.getJugador().setProbCritico(jugador.getProbCritico());
		Terreno.terreno.getJugador().setDanoCritico(jugador.getDanoCritico());

		ArrayList<EfectoSobreEstadisticas> efectosFinales = new ArrayList<EfectoSobreEstadisticas>();

		EfectoSobreEstadisticas[] efectosAux = castEfectos(Terreno.terreno.getEfectosEnJugador());

		ArrayList<Integer> debuffos = new ArrayList<Integer>();

		for (int i = 0; i < efectosAux.length; i++) {

			if (efectosAux[i].getDuracion() > 0) {

				efectosAux[i].setDuracion(efectosAux[i].getDuracion() - 1);
				efectosFinales.add(efectosAux[i]);

				// Convierto los efectos a True para poder reaplicarlos más tarde
				if (!efectosAux[i].isObjetivo()) {
					efectosAux[i].setObjetivo(true);
					debuffos.add(efectosFinales.size() - 1);
				}

			}
		}

		efectosAux = new EfectoSobreEstadisticas[efectosFinales.size()];

		for (int i = 0; i < efectosAux.length; i++) {
			efectosAux[i] = efectosFinales.get(i);

		}

		Carta cartaAux = new Carta(0, null, null, null, 0, null, efectosAux);

		Carta.ejecutarCarta(cartaAux, 0);

		// Una vez reaplico los efectos, vuelvo a convertir esos en false

		for (int i = 0; i < debuffos.size(); i++) {

			efectosAux[i].setObjetivo(false);

		}

		Terreno.terreno.setEfectosEnJugador(efectosAux);

	}

	public static void aplicaEfectosEspeciales(String trait) {

		switch (trait) {
		
		case "Confianza":
			
			EfectosEspeciales.confiadoMetodo();
			
			break;
		
		}

	}

	// Falta duplicar el método para que sea tolerable a dos o tres enemigos.
	/**
	 * 
	 * @param jugador
	 * @param NPC
	 */
	public static void menuCombate(Jugable jugadorPlantilla, Enemigo NPCPlantilla) {

		boolean ganador = true;
		EfectosEspeciales sp = new EfectosEspeciales();
		boolean finTurno = false, tiroCarta = false, finCombate = false;
		Carta[] mazoAux = null, mano;
		int bloqueoInicial = 0;
		Enemigos ens = new Enemigos();

		Enemigo NPC = new Enemigo(NPCPlantilla);

		NPC.setNivel(NPCPlantilla.getNivel());
		NPC.setAtaque(NPCPlantilla.getAtaque());
		NPC.setBloqueo(NPCPlantilla.getBloqueo());
		NPC.setVida(NPCPlantilla.getVida());
		NPC.setDefensa(NPCPlantilla.getDefensa());
		NPC.setDanoCritico(NPCPlantilla.getDanoCritico());
		NPC.setProbCritico(NPCPlantilla.getProbCritico());
		NPC.setVidaRestante(NPC.getVida());

		if (!enemigoClave) {

			Enemigo.ajustaParametros(NPC);
		
		} else {
			enemigoClave = false;
		}

		Jugable jugador = new Jugable(jugadorPlantilla);

		Terreno.terreno = new Terreno(null, new Carta[0], new Carta[0], barajeo(jugador.getMazo()),
				jugador.getPasivas(), new Efecto[] {}, jugador, NPC);

		int numCartas = 5;

		do {
			Terreno.terreno.getJugador().setManaRestante(Terreno.terreno.getJugador().getMana());
			Terreno.terreno.getJugador().setBloqueo(bloqueoInicial);
			mano = new Carta[numCartas];
			/*
			 * Este complicado if-else se encarga de dos cosas. Repartir cartas que tiene el
			 * jugador y definir el mazo restante del turno. Para ello, si la longitud es
			 * mayor del numero de cartas que se roban el siguiente mazo se crea con esa
			 * longitud restada y sin las cartas robadas. En caso contrario se reciclan las
			 * cartas descartadas ya barajadas, se repone el mazo y la mano con las cartas
			 * restantes del mazo con el paso intermedio de eliminar de descartes las cartas
			 * "recicladas".
			 */

			if (Terreno.terreno.getMazoRestante().length < numCartas) {

				mazoAux = new Carta[Terreno.terreno.getDescartes().length + Terreno.terreno.getMazoRestante().length];

				for (int i = 0; i < Terreno.terreno.getMazoRestante().length; i++) {
					mano[i] = Terreno.terreno.getMazoRestante()[i];
					mazoAux[i] = Terreno.terreno.getMazoRestante()[i];
				}

				for (int i = Terreno.terreno.getMazoRestante().length; i < Terreno.terreno.getDescartes().length
						+ Terreno.terreno.getMazoRestante().length; i++) {
					mazoAux[i] = Terreno.terreno.getDescartes()[i - Terreno.terreno.getMazoRestante().length];
				}

				Terreno.terreno.setDescartes(Combate.barajeo(mazoAux));
				Terreno.terreno.setMazoRestante(Terreno.terreno.getDescartes());
				Terreno.terreno.setDescartes(new Carta[] {});

			}

			if (Terreno.terreno.getMazoRestante().length == numCartas) {

				for (int i = 0; i < numCartas; i++) {
					mano[i] = Terreno.terreno.getMazoRestante()[i];
				}

				Terreno.terreno.setMazoRestante(new Carta[0]);

			} else {

				mazoAux = new Carta[Terreno.terreno.getMazoRestante().length - numCartas];

				for (int i = 0; i < numCartas; i++) {
					mano[i] = Terreno.terreno.getMazoRestante()[i];
				}

				for (int i = 0; i < Terreno.terreno.getMazoRestante().length - numCartas; i++) {
					mazoAux[i] = Terreno.terreno.getMazoRestante()[i + numCartas];
				}

				Terreno.terreno.setMazoRestante(mazoAux);

			}

			Terreno.terreno.setMano(mano);
			// Reparto completado en este punto

			do {
				
				if (Terreno.terreno.getJugador().getVidaRestante() > Terreno.terreno.getJugador().getVida()) {
					Terreno.terreno.getJugador().setVidaRestante(Terreno.terreno.getJugador().getVida());
				}

				if (Terreno.terreno.getE1().getVidaRestante() > Terreno.terreno.getE1().getVida()) {
					Terreno.terreno.getE1().setVidaRestante(Terreno.terreno.getE1().getVida());
				}
				String opciones[] = new String[Terreno.terreno.getMano().length + 2];
				ArrayList<Carta> cartasMano = new ArrayList<Carta>();

				for (int i = 0; i < opciones.length - 2; i++) {

					opciones[i] = Terreno.terreno.getMano()[i].getNombre() + " ["
							+ Terreno.terreno.getMano()[i].getCoste() + "]";
					cartasMano.add(Terreno.terreno.getMano()[i]);

				}

				opciones[opciones.length - 2] = "Finalizar turno";
				opciones[opciones.length - 1] = "?";

				do {

					int eleccionCarta = JOptionPane.showOptionDialog(null, Interfaz.creaInterfazBatalla(jugador, NPC),
							"Combate contra " + NPC.getNombre(), 0, 0, new ImageIcon("fight.png"), opciones, "?");

					int eleccionObjetivo = 0;

					if (eleccionCarta == opciones.length - 2) {

						finTurno = true;
						tiroCarta = true;
						ganador = false;

					} else if (eleccionCarta == opciones.length - 1) {

						Interfaz.informacionGeneral();

					} else {

						if (cartasMano.get(eleccionCarta).getCoste() > Terreno.terreno.getJugador().getManaRestante()) {

							JOptionPane.showMessageDialog(null, "Coste superior al asumible",
									"\"No tengo energía para esto...\"", 0, null);

						} else {

							if (puedeElegirRival(cartasMano.get(eleccionCarta))) {

								eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
										"Combate contra " + NPC.getNombre(), 0, 0, new ImageIcon(),
										new String[] { "Atrás", NPC.getNombre() }, "Atrás");
								if (eleccionObjetivo != 0 && eleccionObjetivo !=-1) {

									Interfaz.ataqueJugador(cartasMano.get(eleccionCarta), eleccionObjetivo);
									Terreno.terreno.getJugador()
											.setManaRestante(Terreno.terreno.getJugador().getManaRestante()
													- cartasMano.get(eleccionCarta).getCoste());
								}
								if (Terreno.terreno.getE1().getVidaRestante() <= 0) {

									finTurno = true;
									finCombate = true;
									ganador = true;

								}

							} else {

								eleccionObjetivo = JOptionPane.showOptionDialog(null, "Elige un objetivo para tu carta",
										"Combate contra " + NPC.getNombre(), 0, 0, new ImageIcon(), new String[] { "Atrás", "Tú" },
										"Atrás");

								if (eleccionObjetivo == 1) {
									Interfaz.ataqueJugador(cartasMano.get(eleccionCarta), -1);
									Terreno.terreno.getJugador()
											.setManaRestante(Terreno.terreno.getJugador().getManaRestante()
													- cartasMano.get(eleccionCarta).getCoste());

									if (cartasMano.get(eleccionCarta).getNombre().equals("Descanso"))
										finTurno = true;
									
								}

								if (Terreno.terreno.getE1().getVidaRestante() <= 0) {

									finTurno = true;
									finCombate = true;
									ganador = true;

								}

							}

						}

						// Este if se encarga de mandar a descartes las cartas según las vayas usando
						if (eleccionObjetivo != 0) {

							Carta[] descartesAux = new Carta[Terreno.terreno.getDescartes().length + 1];

							for (int j = 0; j < Terreno.terreno.getDescartes().length; j++) {

								descartesAux[j] = Terreno.terreno.getDescartes()[j];

							}
							descartesAux[Terreno.terreno.getDescartes().length] = cartasMano.get(eleccionCarta);
							Terreno.terreno.setDescartes(descartesAux);

							cartasMano.remove(eleccionCarta);
							tiroCarta = true;
						}

					}

				} while (!tiroCarta);
				tiroCarta = false;

				mano = new Carta[cartasMano.size()];

				for (int i = 0; i < cartasMano.size(); i++) {

					mano[i] = cartasMano.get(i);

				}

				Terreno.terreno.setMano(mano);

				Terreno.terreno.setDescartes(barajeo(Terreno.terreno.getDescartes()));
				
				

			} while (!finTurno);
			if (!ganador) {

				finTurno = false;

				Carta[] descartesAux = new Carta[Terreno.terreno.getDescartes().length
						+ Terreno.terreno.getMano().length];

				for (int j = 0; j < Terreno.terreno.getDescartes().length; j++) {

					descartesAux[j] = Terreno.terreno.getDescartes()[j];

				}

				for (int j = 0; j < Terreno.terreno.getMano().length; j++) {

					descartesAux[j + Terreno.terreno.getDescartes().length] = Terreno.terreno.getMano()[j];

				}

				Terreno.terreno.setMano(new Carta[0]);
				Terreno.terreno.setDescartes(descartesAux);
				Terreno.terreno.setDescartes(barajeo(Terreno.terreno.getDescartes()));

				finCombate = Interfaz.ataqueEnemigo(1);

				if (Terreno.terreno.getJugador().getVidaRestante() <= 0) {
					ganador = false;
				}

				revisaEfectosJugador(jugadorPlantilla);

				if (Terreno.terreno.getE1().getSiguienteAccion().getNombre().equals("Fortalecer") && Terreno.terreno.getE1().getNombre().equals("Goburina")) {

					Terreno.terreno.getE1().setSiguienteAccion(Terreno.terreno.getE1().getAtaques()[2]);
					
				} else if (Terreno.terreno.getE1().getSiguienteAccion().getNombre().equals("Gobumartillo") && Terreno.terreno.getE1().getNombre().equals("Goburina")){
					
					Terreno.terreno.getE1().setSiguienteAccion(Terreno.terreno.getE1().getAtaques()[3]);
					
				} else {
					
					Terreno.terreno.getE1().setSiguienteAccion(eleccionSiguienteAccion(1));
					
				}
			}
		} while (!finCombate);

		if (ganador) {
			JOptionPane.showMessageDialog(null, "", "¡¡Victoria!!", 0, new ImageIcon("win.gif"));
		} else {
			JOptionPane.showMessageDialog(null, "", "Game over", 0, new ImageIcon("gameover.gif"));
		}
	}

}
