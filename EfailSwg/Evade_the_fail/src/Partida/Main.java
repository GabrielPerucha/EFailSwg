package Partida;

import ClasesEntidades.*;
import Combate.Combate;
import Efectos.EfectosEspeciales;
import Movimientos.Cartas;

public class Main {

	public static void main(String[] args) {

		//Bases de datos por hacer
		
		String nombreJugador;
		Personajes pjs = new Personajes();
		Enemigos ens = new Enemigos();

		Enemigo goburina = new Enemigo(ens.Goburina);
		Jugable jugador = new Jugable (pjs.caballeroPrueba);
		
		nombreJugador = Interfaz.seleccionadorBeta(Interfaz.menuInicialBeta());
		
		if (nombreJugador != null) {
			
			jugador.setNombre(nombreJugador);
			Combate.inicioCombate(goburina, jugador);
			Combate.menuCombate(jugador, goburina);
			
		}
		
	}

}
