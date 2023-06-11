package Efectos;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;

public class EfectosEspeciales {

	
	//Descripcion y efectos en lineas separadas
	
	public EfectoEspecial tesonDeGuerrero = new EfectoEspecial("Un guerrero nunca se cansa. Todos los turnos recarga tu maná",
			new EfectoSobreEstadisticas [] {new EfectoSobreEstadisticas("Tesón", 1, 4, 100, 0, true)});
	
	/*public EfectoEspecial tensionDeEnemigo = new EfectoEspecial("Te pones nervioso al ver a un enemigo, quién sabe si él será quien acabe con tu vida",
			new EfectoSobreEstadisticas [] {new EfectoSobreEstadisticas("vida", 1, 0, 100, 0, true)});
	*/
	public EfectoEspecial valorDelCaballero = new EfectoEspecial("Solo los caballeros de corazón puro pueden presumir de esta capacidad de resistencia",
			new EfectoSobreEstadisticas [] {new EfectoSobreEstadisticas("vidaRestante", 1, 2, 100, 0, true)});
	
	//Efectos Jugador
	
	public static EfectoEspecial confiado = new EfectoEspecial("Dejas de lado tus miedos convenciéndote de que lograrás tu objetivo", 
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("Confianza", 1, 0, 2, 0, true)});

	

	public static void confiadoMetodo() {
		boolean estaConfiado = false;

		EfectoSobreEstadisticas [] efectosJug = Combate.castEfectos(Terreno.terreno.getEfectosEnJugador());
		EfectoSobreEstadisticas [] efectosJugAux = new EfectoSobreEstadisticas [efectosJug.length-1];
		
		for (int i = 0, j = 0; i < Terreno.terreno.getEfectosEnJugador().length; i++, j++) {
			
			 if(efectosJug[i].getEstadistica().equals("Confianza")) {
				 j++;
				 estaConfiado = true;
			 }
			 if (j<efectosJugAux.length)
			 efectosJugAux[j] = efectosJug[j];
		}
		
		if (estaConfiado) {
			
			confiado.setEfectos(new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("Ataque", 1.25, 0, 1, 0, true)});
			Terreno.terreno.setEfectosEnJugador(efectosJugAux);
			
		} else {
			
			confiado.setEfectos(new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("Confianza", 1, 0, 2, 0, true)});
			
		}
	}
	
	
	
	
	
	
	//SLIMES
	public EfectoEspecial babaSlimeRB = new EfectoEspecial("Baba de Slime pegajosa que te vuelve más torpe al atacar.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.9, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRA = new EfectoEspecial("Pese a haberte vuelto más fuerte, sientes que los enemigos tambien lo hicieron.\nDura 2 turnos",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.8, 0, 2, 0, false)});
	
	public EfectoEspecial babaSlimeRM = new EfectoEspecial("Una baba más fuerte a la que el héroe no le tiene miedo.\nDura 3 turnos", 
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("ataque", 0.75, 0, 4, 0, false)});
	
	
	//JUEGO CON TURNOS
	

	
}
