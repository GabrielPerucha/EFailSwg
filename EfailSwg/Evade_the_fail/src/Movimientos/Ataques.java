package Movimientos;

import ClasesEntidades.Enemigo;
import ClasesEntidades.Jugable;
import Combate.*;
import Efectos.*;

public class Ataques {

	EfectosEspeciales ef = new EfectosEspeciales(); 
	
	//Sintaxis de efectos: Salto de linea cuando no cabe en pantalla y la declaracion de efectos en una linea aparte
	
	//Golpe genérico
	public Ataque golpeRB = new Ataque("Un golpe con la mano abierta, siempre confiable.\nPotencia: 100\nProbabilidad: 20", "Golpe", 20, 100, 
			new Efecto[]{new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false)});
	
	public Ataque golpeRA = new Ataque("Es un golpe tan simple que cada vez lo ves menos.\nPotencia: 100\nProbabilidad: 10", "Golpe", 10, 100,
			new Efecto[]{new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false)});

	//En RM no hay "Golpe"
	
	
	//Debuff genérico
	public Ataque rugidoRB = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuración: 1 turnos", "Rugido", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas("defensa", 0.9, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.9, 0, 1, 0, false)});
	
	public Ataque rugidoRA = new Ataque("Grito de monstruo capaz de aterrorizar a cualquiera que no haya explorado antes.\nBaja un 10% tu ataque y defensa\nProbabilidad: 15\nDuracion: 1 turno", "Rugido", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas("defensa", 0.9, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.9, 0, 1, 0, false)});
	
	public Ataque rugidoRM = new Ataque("Grito de monstruo que has oido tantas veces que ahora hace que te emociones.\nBaja un 10% tu ataque y defensa y baja tu bloqueo en 2\nProbabilidad: 15\nDuracion 1 turno", "Rugido", 10, 0,
			new Efecto[] {new EfectoSobreEstadisticas("defensa", 0.9, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.9, 0, 1, 0, false), new EfectoSobreEstadisticas("bloqueo", 1, -2, 1, 1, false)});
	
	
	//Curacion genérica
	public Ataque descansoRB = new Ataque("Una siestecita nunca viene mal.\nCura al rival 10 puntos de vida\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas ("vidaRestante", 1, 10, 1, 0, true)});
	
	//No hay de rango alto
	
	public Ataque descansoRM = new Ataque("Sueño reparador que tú no puedes disfrutar.\nCura al rival 20 puntos de vida y un 5% de su total\nProbabilidad: 15", "Descanso", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas ("vidaRestante", 1.05, 20, 1, 0, true)});
	
	
	//Buff genérico
	public Ataque fortalecerRB = new Ataque("Es como una semana de gimnasio, pero en 1 minuto y contra ti.\nAumenta el ataque un 33% durante el siguiente turno\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.33, 0, 1, 1, false)});
	
	public Ataque fortalecerRA = new Ataque("Los monstruos de este lugar tan peligroso logran tensar sus músculos a un nuevo nivel si se sienten en peligro.\nAumenta el ataque un 50% durante el siguiente turno\nProbabilidad: 15", "Fortalecer", 15, 0,
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.50, 0, 1, 1, false)});

	//No hay versión de rango maestro
	
	//TO DO version mejorada de fortalecer para goblins o algun monstruo
	
	
																																																		/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	//Ataques ESPECIALES de ciertos enemigos
	
	
	/*
	 * SLIMES
	 */
	
	//Ataque básico de Slimes
	public Ataque babaRB = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles."
			+ "\nPor suerte el moco aunque incómodo está bastante calentito"
			+ "\nGolpea y baja un 10%\nPotencia: 120\nProbabilidad: 30.", "Baba de Slime", 30, 120, 
			new Efecto[]{new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), ef.babaSlimeRB});
	
	public Ataque babaRA = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo, no parece dolerles."
			+ ". Poco a poco te vaas cansando de la textura de la baba, mas incluso que antes"
			+ "\nGolpea y baja un 20% el ataque\nPotencia: 135\nProbabilidad: 20", "Baba de Slime", 20, 135, 
			new Efecto[]{new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), ef.babaSlimeRA});
	
	public Ataque babaRM = new Ataque("Ataque propio de Slimes, curiosamente pese a desprenderse de parte de su cuerpo.", "Baba de Slime"
			+ "\nGolpea y baja un 25% el ataque\nPotencia: 135\nProbabilidad: 10", 10, 135, 
			new Efecto[]{new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), ef.babaSlimeRM});
	
	
	//Buff basico de slimes
	public Ataque endurecerRB = new Ataque("La blanda bola de gelatina trata de aumentar su defensa endureciendose, pero reduce su movilidad"
			+ "\nBaja ataque un 15% y sube defensa un 33% durante un turno\nProbabilidad: 20", "Endurecer", 20, 0,
			new Efecto[]{new EfectoSobreEstadisticas("defensa", 1.33, 0, 2, 0, true), new EfectoSobreEstadisticas("ataque", 0.85, 0, 2, 0, true)});
	
	public Ataque endurecerRA = new Ataque("La blanda bola de gelatina trata de aumentar su defensa endureciendose, pero reduce su movilidad"
			+ "\nBaja ataque un 15% y sube defensa un 50% durante un turno\nProbabilidad: 20", "Endurecer", 20, 0,
			new Efecto[]{new EfectoSobreEstadisticas("defensa", 1.5, 0, 2, 0, true), new EfectoSobreEstadisticas("ataque", 0.85, 0, 2, 0, true)});
	
	//El endurecer de RM depende del elemento.
	
	
	
	/*
	 * GOBLINS
	 */
	
	//Goblin desarmado
	public Ataque desarmeRB = new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 30% un turno\nPotencia: 70\nProbabilidad 35", "Desarme", 35, 70,
			new Efecto[] {new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.7, 0, 1, 0, false)});
	
	public Ataque desarmeRA = new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 50% un turno\nPotencia: 90\nProbabilidad 35", "Desarme", 35, 90,
			new Efecto[] {new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.5, 0, 1, 0, false)});
	
	public Ataque desarmeRM= new Ataque("¡Un duende desarmado te ataca y te tira el arma!\nBaja el ataque un 50% un turno\nPotencia: 110\nProbabilidad 35", "Desarme", 35, 110,
			new Efecto[] {new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false), new EfectoSobreEstadisticas("ataque", 0.9, 0, 1, 0, false)});
	
	
	//Goblin con hacha
	public Ataque hachazoRB = new Ataque("El duende con su portentosa arma te ataca sin piedad\nAumenta la defensa en un 50% un turno"
			+ "\nPotencia: 200 una vez tras un turno\nProbabilidad: 35", "Hachazo", 35, 200,
			new Efecto[]{new EfectoSobreEstadisticas("defensa", 1.5, 0, 1, 0, true), new EfectoSobreEstadisticas("vidaRestante", 1, 0, 1, 1, false)});
	
	public Ataque hachazoRA = new Ataque("El duende con su portentosa arma te ataca sin piedad\nAumenta la defensa en un 50% un turno"
			+ "\nPotencia: 250 una vez tras un turno\nProbabilidad: 35", "Hachazo", 35, 250,
			new Efecto[]{new EfectoSobreEstadisticas("defensa", 1.5, 0, 1, 0, true), new EfectoSobreEstadisticas("vidaRestante", 1, 0, 1, 1, false)});
	
	
	//Goblin con espadas
	public Ataque espadazoRB = new Ataque("Extrañamente una criatura fantastica utiliza mejor la espada que muchas personas reales.\n"
			+ "Aumenta la probabilidad de critico un 25% y el daño crítico un 20% por 1 turno\n Potencia: 100\nProbabilidad: 35", "Espadazo", 35, 100,
			new Efecto[] {new EfectoSobreEstadisticas("probCritico", 1, 25, 1, 0, true), new EfectoSobreEstadisticas("danoCritico", 1.2, 0, 1, 0, true), new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false)});
	
	public Ataque espadazoRA = new Ataque("Duende de los criticos (ahora es personal).\n"
			+ "Aumenta la probabilidad de critico un 50% y el daño crítico un 30% por 1 turno\n Potencia: 100\nProbabilidad: 35", "Espadazo", 35, 100,
			new Efecto[] {new EfectoSobreEstadisticas("probCritico", 1, 50, 1, 0, true), new EfectoSobreEstadisticas("danoCritico", 1.3, 0, 1, 0, true), new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false)});
	
	//Hacer un ataque de maestro de la espada
	
	public Ataque martillazoDeGobu = new Ataque("¡¡¡GOBUUUU!!!\n"
			+ "Aumenta la probabilidad de critico un 100% y el daño crítico un 100% por 1 turno\n Potencia: 500\nProbabilidad: siempre después de fortalecer", "Gobumartillo", 0, 1000,
			new Efecto[] {new EfectoSobreEstadisticas("probCritico", 1, 95, 1, 0, true), new EfectoSobreEstadisticas("danoCritico", 2, 0, 1, 0, true), new EfectoSobreEstadisticas("dano", 1, 0, 1, 0, false)});
	
	public Ataque vagueo = new Ataque("¡Gobu sueño!\n"
			+ "Gobu siempre fue muy imprevisible, de vez en cuando simplemente se duerme\nCura un 10% de su vida\nProbabilidad: 20", "Govagueo", 20, 0,
			new Efecto[] {new EfectoSobreEstadisticas ("vidaRestante", 1, 20, 1, 0, true)});
	
	public Ataque hiperactividad = new Ataque("¡Gobu Gobu Gooobuuu!\n"
			+ "Hormonas revolucionadas provocan un aumento constante del ataque de Goburina\nAumenta su ataque un 10% durante tres turnos, el daño crítico un 20% durante 2 y la defensa un 30% durante uno"
			+ "\nProbabilidad: 20", "Go Go Gobu!", 20, 0,
			new Efecto[] {new EfectoSobreEstadisticas("ataque", 1.1, 0, 3, 0, true), new EfectoSobreEstadisticas("danoCritico", 1.2, 0, 2, 0, true), new EfectoSobreEstadisticas("defensa", 1.3, 0, 1, 0, true), });
	
	
	
	
}
