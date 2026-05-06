package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton btnNewButton;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_1 frame = new Ventana_1();
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
	public Ventana_1() {
		getContentPane().setBackground(new Color(235, 222, 207));
		getContentPane().setLayout(null);
		
		
		//TITULO INICIO
		JLabel lblNewLabel = new JLabel("INICIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(172, 11, 90, 45);
		getContentPane().add(lblNewLabel);
		
		
		//BOTON AÑADIR CLIENTE	
		btnNewButton = new JButton("Añadir Cliente");
		btnNewButton.setBounds(167, 79, 99, 23);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("DEBUG: Click detectado"); // Esto DEBE salir en consola
		        Ventana_AñadirCliente ventana = new Ventana_AñadirCliente();
		        ventana.setVisible(true);
		    }
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(167, 79, 99, 23);
		getContentPane().add(btnNewButton);
		
		
		//BOTON RESERVAR HABITACIÓN
		JButton btnNewButton_1 = new JButton("Reservar Habitación");
		btnNewButton_1.setBounds(152, 113, 129, 23);
		getContentPane().add(btnNewButton_1);
		
		
		//BOTON ELIMINAR RESERVA
		JButton btnNewButton_2 = new JButton("Eliminar Reserva");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(161, 181, 111, 23);
		getContentPane().add(btnNewButton_2);
		
		
		//BOTON ACTUALIZAR RESERVA
		JButton btnNewButton_3 = new JButton("Actualizar Reserva");
		btnNewButton_3.setBounds(155, 147, 123, 23);
		getContentPane().add(btnNewButton_3);
		
	}
}
