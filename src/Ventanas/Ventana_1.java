package Ventanas;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JPanel contentPane;

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

	public Ventana_1() {
		setSize(450, 350); // TAMAÑO DE LA VENTANA
		setLocationRelativeTo(null); // CENTRAR LA VENTANA

		getContentPane().setBackground(new Color(235, 222, 207));
		getContentPane().setLayout(null);

		// TITULO INICIO
		JLabel lblNewLabel = new JLabel("INICIO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(164, 41, 105, 45);
		getContentPane().add(lblNewLabel);

		// BOTON AÑADIR CLIENTE
		btnNewButton = new JButton("Añadir Cliente");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(142, 110, 150, 23);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			// ABRIR VENTANA AÑADIR CLIENTE DESDE VENTANA_1
			public void actionPerformed(ActionEvent e) {
				Ventana_AñadirCliente ventana = new Ventana_AñadirCliente();
				ventana.setVisible(true);
				dispose(); // CERRAR VENTANA
			}
		});
		getContentPane().add(btnNewButton);

		// BOTON RESERVAR HABITACIÓN
		JButton btnNewButton_1 = new JButton("Reservar Habitación");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(142, 144, 150, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			// ABRIR VENTANA RESERVAR HABITACIÓN DESDE VENTANA_1
			public void actionPerformed(ActionEvent e) {
				Ventana_ReservarHabitacion ventana = new Ventana_ReservarHabitacion();
				ventana.setVisible(true);
				dispose(); // CERRAR VENTANA
			}
		});
		getContentPane().add(btnNewButton_1);

		// BOTON ESTADO HABITACIÓN
		JButton btnNewButton_3 = new JButton("Estado Habitación");
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(142, 178, 150, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
		    // ABRIR VENTANA ESTADO HABITACIÓN DESDE VENTANA_1
		    public void actionPerformed(ActionEvent e) {
		        Ventana_EstadoHabitacion ventana = new Ventana_EstadoHabitacion();
		        ventana.setVisible(true);
		        dispose(); // CERRAR VENTANA
		    }
		});
		getContentPane().add(btnNewButton_3);
	
		// BOTON ELIMINAR RESERVA
		JButton btnNewButton_2 = new JButton("Eliminar Reserva");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(142, 212, 150, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			// ABRIR VENTANA ELIMINAR RESERVA DESDE VENTANA_1
			public void actionPerformed(ActionEvent e) {
				Ventana_EliminarReserva ventana = new Ventana_EliminarReserva();
				ventana.setVisible(true);
				dispose(); // CERRAR VENTANA
			}
		});
		getContentPane().add(btnNewButton_2);

		setResizable(false);

		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(0, 0, 434, 311);
		ImageIcon icono1 = new ImageIcon(Ventana_1.class.getResource("/Imagenes/Fotillo.png"));
		Image imagen1 = icono1.getImage().getScaledInstance(450, 350, Image.SCALE_SMOOTH);
		ImageIcon iconoAjustado1 = new ImageIcon(imagen1);
		lblFoto1.setIcon(iconoAjustado1);
		getContentPane().add(lblFoto1);
	}
}