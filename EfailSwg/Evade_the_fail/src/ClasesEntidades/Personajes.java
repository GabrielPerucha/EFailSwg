package ClasesEntidades;

import Efectos.*;
import Movimientos.*;

public class Personajes {

	Cartas crt = new Cartas();
	
	EfectosEspeciales spfx = new EfectosEspeciales();
	
	public Jugable caballero = new Jugable(null, 5, 40, 40, 25, 25, 5, 50, 0, 3, 3, "Caballero", null,
			new Carta [] {crt.ofensa, crt.ofensa1, crt.ofensa2, crt.ofensa3, crt.ofensa4,
						  crt.defensa, crt.defensa1, crt.defensa2, crt.defensa3, crt.defensa4,
						  crt.confianza, crt.confianza1, crt.descanso, crt.descanso1, crt.bestialidad,
						  crt.golpeDeForja, crt.golpeDeSabiduría, crt.golpePrimigenio, crt.golpeInvertido,
						  crt.precisionMaxima, crt.preparacion, crt.meditacion},
			new Efecto[] {spfx.tesonDeGuerrero, spfx.valorDelCaballero});
	
	public Jugable caballeroPrueba = new Jugable(null, 50, 125, 125, 60, 60, 5, 50, 0, 3, 3, "Caballero", null,
			new Carta [] {crt.ofensa, crt.ofensa1, crt.ofensa2, crt.ofensa3, crt.ofensa4,
						  crt.defensa, crt.defensa1, crt.defensa2, crt.defensa3, crt.defensa4,
						  crt.confianza, crt.confianza1, crt.descanso, crt.descanso1, crt.bestialidad,
						  crt.golpeDeForja, crt.golpeDeSabiduría, crt.golpePrimigenio, crt.golpeInvertido,
						  crt.precisionMaxima, crt.preparacion, crt.meditacion},
			new Efecto[] {spfx.tesonDeGuerrero, spfx.valorDelCaballero});
	
	
	
	public Jugable mago = new Jugable(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
	
	
	public Jugable asesino = new Jugable(null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
	
	
	
	
}
