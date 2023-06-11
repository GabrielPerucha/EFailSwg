package Partida;

import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Efectos.*;
import Movimientos.*;

public class MainPrueba {

	public static void main(String[] args) {
		
		Personajes pjs = new Personajes();
		
		Cartas crs = new Cartas();
		
		Enemigos ens = new Enemigos();
		
		EfectosEspeciales spfx = new EfectosEspeciales();
		
		Enemigo Slime = ens.GoblinEspadaRB;
		
		Jugable jugador = new Jugable(pjs.caballero);
		
		jugador.setNombre("Alexio");
		
		Combate.inicioCombate(Slime, jugador);
		Combate.menuCombate(jugador, Slime);
		
		
	}

}