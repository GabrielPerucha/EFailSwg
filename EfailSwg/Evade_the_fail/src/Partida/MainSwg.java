package Partida;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ClasesEntidades.*;
import Combate.*;
import Efectos.*;
import Movimientos.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainSwg extends JFrame {
	
	String nombreJugador;
	Personajes pjs = new Personajes();
	Enemigos ens = new Enemigos();

	Enemigo goburina = new Enemigo(ens.Goburina);
	Jugable jugador = new Jugable (pjs.caballeroPrueba);
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSwg frame = new MainSwg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainSwg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos a una nueva partida de Evade The Fail");
		lblNewLabel.setBounds(206, 61, 325, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnPartidaNueva = new JButton("Partida Nueva");
		btnPartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombreJugador = Interfaz.seleccionadorBeta(0);
				if (nombreJugador != null) {
					
					jugador.setNombre(nombreJugador);
					Combate.inicioCombate(goburina, jugador);
					Combate.menuCombate(jugador, goburina);
					
				}
			}
		});
		btnPartidaNueva.setBounds(173, 315, 116, 56);
		contentPane.add(btnPartidaNueva);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.setBounds(445, 315, 116, 56);
		contentPane.add(btnEstadisticas);
	}
}
