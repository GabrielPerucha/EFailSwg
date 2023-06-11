package Movimientos;

import javax.swing.Icon;

import ClasesEntidades.*;
import Efectos.*;
import Combate.*;
import Partida.*;


public class Cartas {

	//	public Carta(int ID, String nombre, String descripcion, String elemento, int coste, String clase,
	//	EfectoSobreEstadisticas efecto1) 
	
	
	/*
	 * public Jugable(String nombre, int nivel, int vida, int vidaRestante, int ataque, int defensa, int velocidad, int probCritico,
			int danoCritico, int bloqueo, int mana, String clase, Icon iconoJugador, Carta[] mazo) {
	 */
	Jugable jugador = new Jugable("Default", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null);
	Enemigo enemigo = new Enemigo("Default", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null);
	Combate combate = new Combate();
	
	int id=0;
	EfectosEspeciales spfx = new EfectosEspeciales();
	
	//Cartas de ejemplo, una de ataque y una de defensa.
	
	public Carta ofensa = new Carta(id++, "Ofensa", "Ataca con fiereza al rival\nAplica + 3 de daño adicional a un golpe normal", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1, -3, 1, 0, false)});
	
	public Carta ofensa1 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nAplica + 3 de daño adicional a un golpe normal", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1, -3, 1, 0, false)});
	
	public Carta ofensa2 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nAplica + 3 de daño adicional a un golpe normal", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1, -3, 1, 0, false)});
	
	public Carta ofensa3 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nAplica + 3 de daño adicional a un golpe normal", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1, -3, 1, 0, false)});
	
	public Carta ofensa4 = new Carta(id, "Ofensa", "Ataca con fiereza al rival\nAplica + 3 de daño adicional a un golpe normal", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1, -3, 1, 0, false)});

	
	public Carta defensa = new Carta(id++, "Defensa", "Defiende la fiereza del rival\nBloqueo: +7\nDefensa: +20% por dos turnos", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 7, 1, 0, true), new EfectoSobreEstadisticas("defensa", 1.2, 0, 2, 0, true)});
	
	public Carta defensa1 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: +7\nDefensa: +20% por dos turnos", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 7, 1, 0, true), new EfectoSobreEstadisticas("defensa", 1.2, 0, 2, 0, true)});
	
	public Carta defensa2 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: +7\nDefensa: +20% por dos turnos", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 7, 1, 0, true), new EfectoSobreEstadisticas("defensa", 1.2, 0, 2, 0, true)});
	
	public Carta defensa3 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: +7\nDefensa: +20% por dos turnos", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 7, 1, 0, true), new EfectoSobreEstadisticas("defensa", 1.2, 0, 2, 0, true)});
	
	public Carta defensa4 = new Carta(id, "Defensa", "Defiende la fiereza del rival\nBloqueo: +7\nDefensa: +20% por dos turnos", "Neutro", 1, "Neutro",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 7, 1, 0, true), new EfectoSobreEstadisticas("defensa", 1.2, 0, 2, 0, true)});
	
	public Carta confianza = new Carta(id++, "Confianza", "Tu seguridad de que ganarás esta pelea te da fuerzas que antes no existían.\n"
			+ "Sube ataque un 25% por este turno. Aplica \"Confiado\" por dos turnos si no está aplicado. Si tienes \"Confiado\", aumenta tu ataque otro 25%",
			"Neutro", 1, "Caballero",
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.25, 0, 1, 0, true), EfectosEspeciales.confiado});
	
	public Carta confianza1 = new Carta(id++, "Confianza", "Tu seguridad de que ganarás esta pelea te da fuerzas que antes no existían.\n"
			+ "Sube ataque un 25% por este turno. Aplica \"Confiado\" por dos turnos si no está aplicado. Si tienes \"Confiado\", aumenta tu ataque otro 25%",
			"Neutro", 1, "Caballero",
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.25, 0, 1, 0, true), EfectosEspeciales.confiado});
	
	public Carta confianza2 = new Carta(id, "Confianza", "Tu seguridad de que ganarás esta pelea te da fuerzas que antes no existían.\n"
			+ "Sube ataque un 25% por este turno. Aplica \"Confiado\" por dos turnos si no está aplicado. Si tienes \"Confiado\", aumenta tu ataque otro 25%",
			"Neutro", 1, "Caballero",
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.25, 0, 1, 0, true), EfectosEspeciales.confiado});
	
	public Carta confianza3 = new Carta(id, "Confianza", "Tu seguridad de que ganarás esta pelea te da fuerzas que antes no existían.\n"
			+ "Sube ataque un 25% por este turno. Aplica \"Confiado\" por dos turnos si no está aplicado. Si tienes \"Confiado\", aumenta tu ataque otro 25%",
			"Neutro", 1, "Caballero",
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.25, 0, 1, 0, true), EfectosEspeciales.confiado});
	
	public Carta descanso = new Carta (id++, "Descanso", "¿Monstruos?, déjalo, tengo mucho sueño... Este parece un buen momento para una cabezadita\n" +
			"Cura un 20% de la salud total y 10 puntos adicionales, acaba tu turno y reduce tu defensa un 20% por este turno",
			"Neutro", 2, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1.2, 10, 1, 0, true), new EfectoSobreEstadisticas("defensa", 0.8, 0, 1, 0, true)});
	
	public Carta descanso1 = new Carta (id, "Descanso", "¿Monstruos?, déjalo, tengo mucho sueño... Este parece un buen momento para una cabezadita\n" +
			"Cura un 20% de la salud total y 10 puntos adicionales, acaba tu turno y reduce tu defensa un 20% por este turno",
			"Neutro", 2, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("vidaRestante", 1.2, 10, 1, 0, true), new EfectoSobreEstadisticas("defensa", 0.8, 0, 1, 0, true)});
	
	public Carta bestialidad = new Carta(id++, "Bestialidad", "Golpe brutal a un enemigo utilízalo con sabiduría porque te dejará exhausto.\n"
			+ "Aplica tres veces más daño que un golpe normal y baja la defensa un 40% del atacante y del objetivo (se activa primero)",
			"Neutro", 3, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("defensa", 0.6, 0, 1, 0, true), new EfectoSobreEstadisticas("defensa", 0.6, 0, 1, 0, false), new EfectoSobreEstadisticas("dano", 3, 0, 1, 0, false)});
	
	public Carta golpeDeForja = new Carta(id++, "Golpe de Forja", "Tu espada se vuelve tan ardiente como tu férreo deseo de prevalecer en este inhóspito lugar. \n"
			+ "Lanza un potente golpe de elemento Destrucción a un sólo enemigo.", "Destrucción", 1, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1.5, 0, 1, 0, false)});
	
	public Carta golpeDeSabiduría = new Carta(id++, "Golpe de Sabiduría", "La fe es un arma, y si lo dudas pregúntale al objetivo de este ataque. \n"
			+ "Lanza un potente golpe de elemento Divinidad a un sólo enemigo.", "Divinidad", 1, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1.5, 0, 1, 0, false)});
	
	public Carta golpePrimigenio = new Carta(id++, "Golpe Primigenio", "Déjate llevar por tus impulsos más primitivos para asestar un potente golpe en nombre de la naturaleza. \n"
			+ "Lanza un potente golpe de elemento Naturaleza a un sólo enemigo.", "Naturaleza", 1, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1.5, 0, 1, 0, false)});
	
	public Carta golpeInvertido = new Carta(id++, "Golpe Invertido", "Habiéndote dejado llevar por la magia negra del lugar, ahora puedes usar el elemento de vacío\n"
			+ "Lanza un potente golpe de elemento Vacío a un sólo enemigo.", "Vacío", 1, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("dano", 1.5, 0, 1, 0, false)});
	
	public Carta precisionMaxima = new Carta(id++, "Precisión Máxima", "Afina tus sentidos, prepara tu arma, tensa tus músculos... puedes hacerlo\n"
			+ "Aumenta tu daño crítico un 100% este turno",
			"Destrucción", 0, "Caballero",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("danoCritico", 1, 100, 1, 0, true)});
	
	public Carta preparacion = new Carta(id++, "Preparación", "Estás listo para asestar un ataque poderoso\n"
			+ "Aumenta tu probabilidad de crítico un 50% durante 3 turnos",
			"Destrucción", 1, "Caballero",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("probCritico", 1, 50, 3, 0, true)});
	
	public Carta meditacion = new Carta(id++, "Meditacion+", "Mentalízate para ganar, pero nadie dijo que sería facil\n"
			+ "Aumenta energía en 2",
			"Divinidad", 0, "Caballero",
			new EfectoSobreEstadisticas[] {new EfectoSobreEstadisticas("manaRestante", 1, 2, 5, 0, true)});
	
	public Carta proteccion = new Carta(id++, "Protección", "Bloqueo perfecto, situacional y efectivo\nBloqueo: MAX\n", "Neutro", 1, "Caballero",
			new EfectoSobreEstadisticas[]{new EfectoSobreEstadisticas("bloqueo", 1, 200, 1, 0, true)});
	
	//Anadir más cartas
	//Pasable a otra clase si es necesario

}